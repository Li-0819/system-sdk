package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iris.mapper.AuthUserMapper;
import com.iris.mapper.ISitemapActionAuthorityMapper;
import com.iris.mapper.ISysActionMapper;
import com.iris.mapper.ISysSitemapsMapper;
import com.iris.model.dto.system.*;
import com.iris.model.entity.SitemapActionAuthority;
import com.iris.model.entity.SysRoles;
import com.iris.model.entity.SysUsers;
import com.iris.model.mapper.SitemapActionAuthorityMapper;
import com.iris.model.mapper.SysRolesMapper;
import com.iris.model.mapper.SysUsersMapper;
import com.iris.model.vo.UserOrganizationVO;
import com.iris.model.vo.UserPrincipalVO;
import com.iris.model.vo.UserRoleVO;
import com.iris.model.vo.UserSiteMapVO;
import com.iris.model.vo.system.EmployeeInfoVO;
import com.iris.model.vo.system.SitemapsAuthListVO;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SysActionVO;
import com.iris.service.AuthUserService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 14:47
 * @Description: AuthUserServiceImpl
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Resource private SysUsersMapper sysUsersMapper;

    @Resource private SysRolesMapper sysRolesMapper;

    @Resource private AuthUserMapper authUserMapper;

    @Resource private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource private ISysSitemapsMapper iSysSitemapsMapper;

    @Resource private SitemapActionAuthorityMapper sitemapActionAuthorityMapper;

    @Resource private ISitemapActionAuthorityMapper iSitemapActionAuthorityMapper;

    @Resource private ISysActionMapper iSysActionMapper;

    @Value("${user.loginPwd}")
    private String loginPwd;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

        QueryWrapper<SysUsers> usersQuery = new QueryWrapper<>();
        usersQuery.eq(SystemCommonField.LOGIN_NAME, loginName);

        //获取用户信息
        SysUsers sysUsers = sysUsersMapper.selectOne(usersQuery);

        JudgeParam.entityIsNotNull(sysUsers, SystemMsgConstants.USER_NAME_UNDEFINED + loginName);

        String usersId = sysUsers.getId();

        //获取用户角色
        List<UserRoleVO> roleList = authUserMapper.getRoles(usersId);

        //获取用户角色
        EmployeeInfoVO employeeInfo = authUserMapper.getEmployeeInfo(usersId);

        //获取组织部门
        List<UserOrganizationVO> organizationList = authUserMapper.getOrganizationList(usersId);

        //TODO 获取菜单权限 authUserMapper.getUserSiteMapList(usersId);
        List<UserSiteMapVO> siteMapList = new ArrayList<>(0);

        return UserPrincipalVO.create(sysUsers, roleList, organizationList, siteMapList, employeeInfo);
    }

    /**
     * 重置/修改密码
     * @param sysUserResetDTO {@link SysUserResetDTO}
     * @return
     */
    @Override
    public void resetPassword(SysUserResetDTO sysUserResetDTO) {

        if (sysUserResetDTO.getResetOrUpdate().equals(1)){

            JudgeParam.paramIsNotNull(sysUserResetDTO.getPassWord(), SystemMsgConstants.PASSWORD_NOT_FOUNT);
        }

        SysUsers sysUsers = DataTransferUtil.model(sysUserResetDTO, new SysUsers());

        String pwd = sysUserResetDTO.getResetOrUpdate().equals(0) ? loginPwd : sysUserResetDTO.getPassWord().trim();

        sysUsers.setLoginPwd(bCryptPasswordEncoder.encode(pwd));

        sysUsersMapper.updateById(sysUsers);
    }

    /**
     * 获取菜单权限
     * @param targetIds 授权对象ID
     * @return
     */
    @Override
    public List<SitemapsAuthVO> getAuthSiteMapByTargetId(List<String> targetIds, Integer isPlatform) {

        List<SitemapsAuthVO> sitemapsAuthVOS;

        if (this.checkIsAdmin(targetIds)) {

            sitemapsAuthVOS = iSysSitemapsMapper.getAuthList(isPlatform);
        }else {

            sitemapsAuthVOS = iSysSitemapsMapper.getAuthSiteMapByTargetId(targetIds, isPlatform);
        }
        return sitemapsAuthVOS;
    }

    /**
     * 菜单功能授权
     * @param authorizationEditDTO {@link SitemapActionAuthorityEditDTO}
     */
    @Override
    public void siteMapActionAuthority(AuthorizationEditDTO authorizationEditDTO) {

        SitemapActionAuthority sitemapActionAuthority = null;

        String targetId = authorizationEditDTO.getTargetId();
        this.deduplication(authorizationEditDTO.getTargetId());

        if (authorizationEditDTO.getSitemapActionAuthorityEditDTOS() != null){

            List<SitemapActionAuthorityEditDTO> sitemapActionAuthorityEditDTOS = authorizationEditDTO.getSitemapActionAuthorityEditDTOS();

            if (sitemapActionAuthorityEditDTOS.size() > 0) {

                for (SitemapActionAuthorityEditDTO actionAuthorityEditDTO : sitemapActionAuthorityEditDTOS) {

                    sitemapActionAuthority = DataTransferUtil.model(actionAuthorityEditDTO, new SitemapActionAuthority());
                    sitemapActionAuthority.setTargetId(targetId);
                    sitemapActionAuthorityMapper.insert(sitemapActionAuthority);

                    for (SiteMapsMateDTO siteMapsMateDTO : actionAuthorityEditDTO.getSiteMapsMateDTOS()) {

                        sitemapActionAuthority = DataTransferUtil.model(siteMapsMateDTO, new SitemapActionAuthority());
                        sitemapActionAuthority.setTargetId(targetId);
                        sitemapActionAuthorityMapper.insert(sitemapActionAuthority);

                        for (ActionMateDTO actionMateDTO : siteMapsMateDTO.getActionMateDTOs()) {

                            sitemapActionAuthority = DataTransferUtil.model(actionMateDTO, new SitemapActionAuthority());
                            sitemapActionAuthority.setTargetId(targetId);
                            sitemapActionAuthorityMapper.insert(sitemapActionAuthority);
                        }
                    }
                }
            }
        }
    }

    /**
     * 根据不同的type获取权限列表
     * @param type 授权目标类型
     * @param targetId 授权目标ID
     * @param isPlatform 是否为平台
     * @return
     */
    @Override
    public List<SitemapsAuthListVO> getSiteMapRelevanceByType(String type, String targetId, Integer isPlatform) {

        return iSysSitemapsMapper.getSiteMapRelevanceByType(type, targetId, isPlatform);

    }

    /**
     * 根据权限ID获取按钮权限
     * @param targetIds 目标权限ids
     * @param sitemapId 菜单id
     * @return
     */
    @Override
    public List<SysActionVO> getAuthActionByTargetIds(List<String> targetIds, String sitemapId) {

        List<SysActionVO> sysActionVOS;

        if (this.checkIsAdmin(targetIds)){
            SysActionListDTO sysActionListDTO = new SysActionListDTO();

            sysActionListDTO.setSitemapId(sitemapId);

            sysActionVOS = iSysActionMapper.getList(sysActionListDTO);
        }else {

            sysActionVOS = iSysSitemapsMapper.getAuthActionByTargetIds(targetIds, sitemapId);
        }

        return sysActionVOS;
    }

    /**
     * 删除菜单数据删除
     * @param targetId {@link SitemapActionAuthority}
     */
    public void deduplication(String targetId){

        if (!JudgeParam.isNullOrUndefined(targetId)){

            iSitemapActionAuthorityMapper.deleteByTargetId(targetId);
        }

    }

    /**
     * 校验权限ids中是否包含超级管理员
     * @param targetIds
     * @return
     */
    public boolean checkIsAdmin(List<String> targetIds){

        SysUsers sysUsers = sysUsersMapper.selectOne(new QueryWrapper<SysUsers>() {{
            eq(SystemCommonField.LOGIN_NAME, SystemCommonField.ADMIN);
        }});

        boolean contains = false;
        QueryWrapper<SysRoles> wrapper = new QueryWrapper<>();
        wrapper.eq(SystemCommonField.CODE, SystemCommonField.SYS_ADMIN);

        SysRoles sysRoles = sysRolesMapper.selectOne(wrapper);

        if (null != sysRoles){

            contains = targetIds.contains(sysRoles.getId());
        }

        if (null != sysUsers){
            contains = targetIds.contains(sysUsers.getId());
        }

        return contains;
    }

    /**
     * 校验员工编号是否正确
     * @param userId 用户ID
     * @param employeeCode 员工Code
     * @return
     */
    @Override
    public Boolean employeeCodeIsCorrect(String userId, String employeeCode) {

        return authUserMapper.employeeCodeIsCorrect(userId, employeeCode);
    }

    /**
     * 验证是否是平台用户
     * @param userId 用户ID
     * @return
     */
    @Override
    public Integer isPlatformUser(String userId) {

        return authUserMapper.isPlatformUser(userId);
    }
}
