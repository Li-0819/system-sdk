package com.iris.mapper;


import com.iris.model.dto.system.SitemapAuthListDTO;
import com.iris.model.entity.SysSitemaps;
import com.iris.model.vo.system.SitemapsAuthListVO;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SitemapsVO;
import com.iris.model.vo.system.SysActionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author RubyWong
 * @date 2020/7/21 14:48
 * @description 菜单管理
 */
@Mapper
public interface ISysSitemapsMapper {

    List<SitemapsAuthVO> getAuthList(@Param("isPlatform") Integer isPlatform);

    List<SitemapsVO> getList(@Param("parentId") String parentId,@Param("isPlatform") Integer isPlatform);

    /**
     * 根据ID修改菜单管理
     * @param sysSitemaps
     */
    void updateSitemapsById(@Param("sysSitemaps") SysSitemaps sysSitemaps);

    /**
     * 获取权限菜单
     * @param targetIds 授权对象ID
     * @param isPlatform 是否为平台
     * @return
     */
    List<SitemapsAuthVO> getAuthSiteMapByTargetId(@Param("targetIds") List<String> targetIds,@Param("isPlatform") Integer isPlatform,
                                                  @Param("orgFiltration") List<String> orgFiltration,
                                                  @Param("orgClass")String orgClass);

    /**
     *
     * 根据不同的type获取权限列表
     * listDTO {@link }
     * @return
     */
    List<SitemapsAuthListVO> getSiteMapRelevanceByType(@Param("listDTO") SitemapAuthListDTO listDTO);

    /**
     * 获取按钮权限
     * @param targetIds 授权对象ids
     * @param sitemapId 授权对象ID
     * @return
     */
    List<SysActionVO> getAuthActionByTargetIds(@Param("targetIds") List<String> targetIds, @Param("sitemapId") String sitemapId);

    /**
     * 根据角色名称获取菜单按钮
     * @param routeName {@link }
     * @return
     */
    List<String> getFiltrationId(@Param("routeName") String routeName);
}
