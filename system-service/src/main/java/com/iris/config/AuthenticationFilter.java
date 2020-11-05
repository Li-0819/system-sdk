package com.iris.config;

import cn.hutool.core.util.StrUtil;
import com.iris.exception.SecurityException;
import com.iris.service.AuthUserService;
import com.iris.utils.jwt.JwtUtil;
import com.iris.utils.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 14:47
 * @Description: 认证过滤器
 */
@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Resource private AuthUserService authUserService;

    @Resource private JwtUtil jwtUtil;

    @Resource private CustomConfig customConfig;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws SecurityException, ServletException, IOException {

        if (customConfig.checkIgnores(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = jwtUtil.getJwtFromRequest(request);

        if (StrUtil.isNotBlank(jwt)) {

            try {

                String username = jwtUtil.getUserNameFromJWT(jwt);
                UserDetails userDetails = authUserService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (SecurityException exception) {

                ResponseUtil.renderJson(response, exception);
            }
        }

        filterChain.doFilter(request, response);
    }
}
