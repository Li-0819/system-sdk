package com.iris.mapper;


import com.iris.model.entity.SysSitemaps;
import com.iris.model.vo.system.SitemapsAuthListVO;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SitemapsVO;
import com.iris.model.vo.system.SysActionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author RubyWong
 * @date 2020/7/21 14:48
 * @description 菜单管理
 */
@Mapper
public interface ISysSitemapsMapper {

    List<SitemapsAuthVO> getAuthList();

    List<SitemapsVO> getList(@Param("parentId") String parentId);

    /**
     * 根据ID修改菜单管理
     * @param sysSitemaps
     */
    void updateSitemapsById(@Param("sysSitemaps") SysSitemaps sysSitemaps);

    /**
     * 获取权限菜单
     * @param targetIds 授权对象ID
     * @return
     */
    List<SitemapsAuthVO> getAuthSiteMapByTargetId(@Param("targetIds") List<String> targetIds);

    /**
     *
     * 根据不同的type获取权限列表
     * @param type 授权目标类型
     * @param targetId 授权目标ID
     * @return
     */
    List<SitemapsAuthListVO> getSiteMapRelevanceByType(@Param("type") String type, @Param("targetId") String targetId);

    /**
     * 获取按钮权限
     * @param targetIds 授权对象ids
     * @param sitemapId 授权对象ID
     * @return
     */
    List<SysActionVO> getAuthActionByTargetIds(@Param("targetIds") List<String> targetIds, @Param("sitemapId") String sitemapId);
}
