package com.iris.service;

import com.iris.model.dto.system.AuthorizationEditDTO;
import com.iris.model.dto.system.SitemapAuthListDTO;
import com.iris.model.dto.system.SysUserResetDTO;
import com.iris.model.vo.system.SitemapsAuthListVO;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SysActionVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 14:47
 * @Description: AuthUserService
 */
public interface AuthUserService extends UserDetailsService {

    /**
     * 重置/修改密码
     * @param sysUserResetDTO {@link SysUserResetDTO}
     * @return
     */
    void resetPassword(SysUserResetDTO sysUserResetDTO);

    /**
     * 根据权限ID获取菜单权限
     * @param targetIds 授权对象ID
     * @param orgClass 机构类型
     * @param isPlatform 是否为平台
     * @return
     */
    List<SitemapsAuthVO> getAuthSiteMapByTargetId(List<String> targetIds, String orgClass, Integer isPlatform);

    /**
     * 菜单功能授权
     * @param authorizationEditDTO {@link AuthorizationEditDTO}
     */
    void siteMapActionAuthority(AuthorizationEditDTO authorizationEditDTO);

    /**
     * 根据不同的type获取权限列表
     * listDTO {@link SitemapAuthListDTO}
     * @return
     */
    List<SitemapsAuthListVO> getSiteMapRelevanceByType(SitemapAuthListDTO listDTO);

    /**
     * 根据权限ID获取按钮权限
     * @param targetIds 目标权限ids
     * @param sitemapId 菜单id
     * @return
     */
    List<SysActionVO> getAuthActionByTargetIds(List<String> targetIds, String sitemapId);

    /**
     * 校验员工编号是否正确
     * @param userId 用户ID
     * @param organizationCode 机构编码
     * @return
     */
    int organizationCodeIsCorrect(String userId, String organizationCode);

    /**
     * 验证是否是平台用户
     * @param userId 用户ID
     * @return
     */
    Integer isPlatformUser(String userId);
}
