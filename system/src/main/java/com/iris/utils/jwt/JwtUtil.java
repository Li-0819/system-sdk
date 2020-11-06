package com.iris.utils.jwt;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iris.exception.CustomException;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.constants.SystemSpecialCode;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author: izanagi
 * @Date: 2020-06-04 10:57
 * @Description: Jwt 工具类
 */
@EnableConfigurationProperties(JwtConfig.class)
@Configuration
@Component
@Slf4j
public class JwtUtil {

    @Resource private JwtConfig jwtConfig;

    @Resource private StringRedisTemplate stringRedisTemplate;

    /**
     * 创建JWT
     *
     * @param rememberMe  记住我
     * @param id          用户id
     * @param subject     用户名
     * @param roles       用户角色
     * @param authorities 用户权限
     * @return JWT
     */
    public String createJWT(Boolean rememberMe, String id, String subject, JSONArray roles, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getKey())
                .claim("roles", roles)
                .claim("authorities", authorities);

        // 设置过期时间
        Long ttl = rememberMe ? jwtConfig.getRemember() : jwtConfig.getTtl();
        if (ttl > 0) {
            builder.setExpiration(DateUtil.offsetMillisecond(now, ttl.intValue()));
        }

        String jwt = builder.compact();
        // 将生成的JWT保存至Redis
        stringRedisTemplate.opsForValue()
                .set(SystemSpecialCode.REDIS_JWT_KEY_PREFIX + id, jwt, ttl, TimeUnit.MILLISECONDS);
        return jwt;
    }

    /**
     * 创建JWT
     *
     * @param authentication 用户认证信息
     * @param rememberMe     记住我
     * @return JWT
     */
    public String createJWT(Authentication authentication, Boolean rememberMe) {

        Object principal = authentication.getPrincipal();
        JSONObject userPrincipal = new JSONObject();
        if (principal != null) {
            String jsonString = JSONObject.toJSONString(principal);
            userPrincipal = JSONObject.parseObject(jsonString);
        }

        JSONArray roles = userPrincipal.getJSONArray("roles");
//        Collection<? extends GrantedAuthority> authorities = userPrincipal.getJSONArray("authorities").toJavaList(GrantedAuthority.class);

        return createJWT(rememberMe, userPrincipal.getString("id"), userPrincipal.getString("loginName"), roles, null);
    }

    /**
     * 解析JWT
     *
     * @param jwt JWT
     * @return {@link Claims}
     */
    public Claims parseJWT(String jwt) {

        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getKey())
                    .parseClaimsJws(jwt)
                    .getBody();

            String id = claims.getId();

            String redisKey = SystemSpecialCode.REDIS_JWT_KEY_PREFIX + id;

            // 校验redis中的JWT是否存在
            Long expire = stringRedisTemplate.getExpire(redisKey, TimeUnit.MILLISECONDS);
            if (Objects.isNull(expire) || expire <= 0) {
                throw new CustomException(SystemMsgConstants.TOKEN_EXPIRED);
            }

            // 校验redis中的JWT是否与当前的一致，不一致则代表用户已注销/用户在不同设备登录，均代表JWT已过期
            String redisToken = stringRedisTemplate.opsForValue()
                    .get(redisKey);
            if (!StrUtil.equals(jwt, redisToken)) {
                throw new SecurityException(SystemMsgConstants.TOKEN_OUT_OF_CTRL);
            }

            //刷新token过期时间
            stringRedisTemplate.expire(redisKey, expire + jwtConfig.getExpire(), TimeUnit.MILLISECONDS);

            return claims;
        } catch (ExpiredJwtException e) {
            log.error("Token 已过期");
            throw new SecurityException(SystemMsgConstants.TOKEN_EXPIRED);
        } catch (UnsupportedJwtException e) {
            log.error("不支持的 Token");
            throw new SecurityException(SystemMsgConstants.TOKEN_PARSE_ERROR);
        } catch (MalformedJwtException e) {
            log.error("Token 无效");
            throw new SecurityException(SystemMsgConstants.TOKEN_PARSE_ERROR);
        } catch (SignatureException e) {
            log.error("无效的 Token 签名");
            throw new SecurityException(SystemMsgConstants.TOKEN_PARSE_ERROR);
        } catch (IllegalArgumentException e) {
            log.error("Token 参数不存在");
            throw new SecurityException(SystemMsgConstants.TOKEN_PARSE_ERROR);
        }
    }

    /**
     * 设置JWT过期
     *
     * @param request 请求
     */
    public void invalidateJWT(HttpServletRequest request) {
        String jwt = getJwtFromRequest(request);
        String username = getUserNameFromJWT(jwt);
        // 从redis中清除JWT
        stringRedisTemplate.delete(SystemSpecialCode.REDIS_JWT_KEY_PREFIX + username);
    }

    /**
     * 根据 jwt 获取用户名
     *
     * @param jwt JWT
     * @return 用户名
     */
    public String getUserNameFromJWT(String jwt) {
        Claims claims = parseJWT(jwt);
        return claims.getSubject();
    }

    /**
     * 从 request 的 header 中获取 JWT
     *
     * @param request 请求
     * @return JWT
     */
    public String getJwtFromRequest(HttpServletRequest request) {

        return request.getHeader(SystemSpecialCode.X_AUTH_TOKEN);

//        String bearerToken = request.getHeader("x-auth-token");
//        if (StrUtil.isNotBlank(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
    }

}
