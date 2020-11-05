package com.iris.service;

import com.iris.model.dto.system.AuthorizationEditDTO;
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
     * @return
     */
    List<SitemapsAuthVO> getAuthSiteMapByTargetId(List<String> targetIds);

    /**
     * 菜单功能授权
     * @param authorizationEditDTO {@link AuthorizationEditDTO}
     */
    void siteMapActionAuthority(AuthorizationEditDTO authorizationEditDTO);

    /**
     * 根据不同的type获取权限列表
     * @param type 授权目标类型
     * @param targetId 授权目标ID
     * @return
     */
    List<SitemapsAuthListVO> getSiteMapRelevanceByType(String type, String targetId);

    /**
     * 根据权限ID获取按钮权限
     * @param targetIds 目标权限ids
     * @param sitemapId 菜单id
     * @return
     */
    List<SysActionVO> getAuthActionByTargetIds(List<String> targetIds, String sitemapId);
}
