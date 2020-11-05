package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysRolesEditDTO;
import com.iris.model.dto.system.SysRolesListDTO;
import com.iris.model.entity.SysRoles;
import com.iris.model.vo.system.SysRolesVO;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysRolesService extends IService<SysRoles> {

    /**
     * 获取角色管理列表
     * @param sysRolesListDTO {@link SysRolesListDTO}
     * @return
     */
    PageResponseVO<SysRolesVO> getList(SysRolesListDTO sysRolesListDTO);

    /**
     * 校验角色是否重复
     * @param code 编码
     * @param name 名称
     * @param id 角色ID
     * @return
     */
    boolean checkRepeat(String code, String name, String id);

    /**
     * 编辑角色信息
     * @param sysRolesEditDTO {@link SysRolesEditDTO}
     */
    void edit(SysRolesEditDTO sysRolesEditDTO);

    /**
     * 获取角色详情
     * @param id 角色ID
     * @return
     */
    SysRolesVO getDetail(String id);
}
