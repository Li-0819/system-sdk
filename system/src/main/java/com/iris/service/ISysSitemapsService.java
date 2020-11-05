package com.iris.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SitemapsEditDTO;
import com.iris.model.entity.SysSitemaps;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SitemapsVO;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysSitemapsService extends IService<SysSitemaps> {

    PageResponseVO<SitemapsAuthVO> getAuthList();

    PageResponseVO<SitemapsVO> getList(String parentId);

    /**
     * 获取菜单管理详情
     * @param id 菜单ID
     * @return
     */
    SysSitemaps getDetail(String id);

    /**
     * 校验相同parentID下是否存在相同name
     * @param id 菜单ID
     * @param parentId 父级ID
     * @param name 名称
     * @return
     */
    boolean checkRepeat(String id, String parentId, String name);

    /**
     * 编辑菜单管理
     * @param sitemapsEditDTO {@link SitemapsEditDTO}
     */
    void edit(SitemapsEditDTO sitemapsEditDTO);
}
