package com.iris.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iris.aspect.annotation.SystemLog;
import com.iris.model.dto.AuthListDTO;
import com.iris.model.dto.ManualLoginDTO;
import com.iris.model.dto.system.AuthorizationEditDTO;
import com.iris.model.dto.system.SysUserResetDTO;
import com.iris.model.entity.SysUsers;
import com.iris.model.vo.system.SitemapsAuthListVO;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SysActionVO;
import com.iris.service.AuthUserService;
import com.iris.service.ISysUsersService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.jwt.JwtUtil;
import com.iris.utils.response.JwtResponseVO;
import com.iris.utils.response.ResponseVO;
import com.iris.utils.security.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 09:55
 * @Description: AuthController
 */
@Tag(name = "Auth", description = "登录登出")
@RequestMapping("/auth")
@RestController
public class SysAuthController {

    @Resource private AuthenticationManager authenticationManager;

    @Resource private JwtUtil jwtUtil;

    @Resource private AuthUserService authUserService;

    @Resource private ISysUsersService iSysUsersService;

    @SystemLog(description = "用户登录")
    @Operation(summary = "用户登录 - izanagi", tags = "Auth")
    @PostMapping("/login")
    public ResponseVO<?> login(@Valid @RequestBody ManualLoginDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLoginName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

//        if (null != authentication && authentication.isAuthenticated()){
//
//            String userId = SecurityUtil.getCurrentUser().get(SystemCommonField.ID).toString();
//
//            // 验证员工编号
//            if (!loginRequest.getIsPlatform()){
//
//                JudgeParam.paramIsNotNull(loginRequest.getEmployeeCode(), SystemMsgConstants.EMPLOYEE_CODE_NOT_FOUNT);
//
//                Boolean b = authUserService.employeeCodeIsCorrect(userId, loginRequest.getEmployeeCode());
//                if (null == b || !b){
//
//                    return ResponseVO.error(SystemMsgConstants.EMPLOYEE_NUMBER_ERROR_OR_USER_INFORMATION_DOES_NOT_EXIST);
//                }
//            }else if (authUserService.isPlatformUser(userId) > 0){
//
//                return ResponseVO.error(SystemMsgConstants.USER_NOT_EXIST);
//            }
//        }

        String jwt = jwtUtil.createJWT(authentication, loginRequest.getRememberMe());

        JwtResponseVO jwtResponseVO = new JwtResponseVO(jwt);

        return ResponseVO.ok(jwtResponseVO);
    }

    @SystemLog(description = "获取当前用户")
    @Operation(summary = "获取当前用户 - izanagi", tags = "Auth")
    @GetMapping("/getCurrentUser")
    public ResponseVO<?> getCurrentUser() {

        return ResponseVO.ok(SecurityUtil.getCurrentUser());
    }

    @SystemLog(description = "修改/重置密码")
    @Operation(summary = "修改/重置密码 -- WindChaser", tags = "Auth")
    @PostMapping("/resetPassword")
    public ResponseVO<?> resetPassword(@Valid @RequestBody SysUserResetDTO sysUserResetDTO){

        SysUsers getOne = iSysUsersService.getOne(new QueryWrapper<SysUsers>() {{
            eq(SystemCommonField.LOGIN_NAME, sysUserResetDTO.getLoginName());
        }});

        JudgeParam.entityIsNotNull(getOne, SystemMsgConstants.USER_NOT_EXIST);

        sysUserResetDTO.setId(getOne.getId());

        authUserService.resetPassword(sysUserResetDTO);

        return ResponseVO.ok(sysUserResetDTO.getResetOrUpdate().equals(0) ? SystemMsgConstants.RESET_PWD_SUCCESS : SystemMsgConstants.CHANGE_PWD_SUCCESS);
    }

    @SystemLog(description = "获取菜单权限")
    @Operation(summary = "获取菜单权限 -- WindChaser", tags = "Auth")
    @PostMapping("/getAuthSiteMapByTargetId")
    public ResponseVO<List<SitemapsAuthVO>> getAuthSiteMapByTargetId(@RequestBody @Valid AuthListDTO authListDTO) {

        if (authListDTO.getTargetIds() == null || authListDTO.getTargetIds().size() <= 0) {

            return ResponseVO.error(SystemMsgConstants.TARGET_ID_NOT_FOUNT);
        }

        List<SitemapsAuthVO> sitemapsAuthVos = authUserService.getAuthSiteMapByTargetId(authListDTO.getTargetIds(),authListDTO.getIsPlatform());

        return ResponseVO.ok(sitemapsAuthVos);
    }

    @SystemLog(description = "根据菜单获取按钮权限")
    @Operation(summary = "根据菜单获取按钮权限 -- WindChaser", tags = "Auth")
    @PostMapping("/getAuthActionByTargetIds")
    public ResponseVO<List<SysActionVO>> getAuthActionByTargetIds(@RequestBody @Valid AuthListDTO authListDTO) {

        if (authListDTO.getTargetIds() == null || authListDTO.getTargetIds().size() <= 0) {

            return ResponseVO.error(SystemMsgConstants.TARGET_ID_NOT_FOUNT);
        }

        List<SysActionVO> sitemapsAuthVos = authUserService.getAuthActionByTargetIds(
                authListDTO.getTargetIds(), authListDTO.getSitemapId());

        return ResponseVO.ok(sitemapsAuthVos);
    }

    @SystemLog(description = "获取权限列表")
    @Operation(summary = "获取权限列表 -- WindChaser", tags = "Auth")
    @GetMapping("/getSiteMapRelevanceByType")
    public ResponseVO<List<SitemapsAuthListVO>> getSiteMapRelevanceByType(@RequestParam("type") String type,
                                                                          @RequestParam("targetId") String targetId,
                                                                          @RequestParam("isPlatform") Integer isPlatform
                                                                          ) {
        List<SitemapsAuthListVO> sitemapsVOS = authUserService.getSiteMapRelevanceByType(type,targetId, isPlatform);

        return ResponseVO.ok(sitemapsVOS);
    }

    @SystemLog(description = "菜单功能授权")
    @Operation(summary = "菜单功能授权 -- WindChaser", tags = "Auth")
    @PostMapping("/siteMapActionAuthority")
    public ResponseVO<?> siteMapActionAuthority(@Valid @RequestBody AuthorizationEditDTO authorizationEditDTO){

        authUserService.siteMapActionAuthority(authorizationEditDTO);

        return ResponseVO.ok(SystemMsgConstants.AUTH_SUCCESS);
    }
}
