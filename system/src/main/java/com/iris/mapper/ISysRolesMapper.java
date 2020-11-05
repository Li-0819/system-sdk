package com.iris.mapper;


import com.iris.model.dto.system.SysRolesListDTO;
import com.iris.model.vo.system.SysRolesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-31 09:47
 * @description NAME
 */
@Mapper
public interface ISysRolesMapper {

    /**
     * 获取角色管理列表
     * @param sysRolesListDTO {@link SysRolesListDTO}
     * @return
     */
    List<SysRolesVO> getList(@Param("sysRolesListDTO") SysRolesListDTO sysRolesListDTO);

    /**
     * 获取角色详情
     * @param id 角色ID
     * @return
     */
    SysRolesVO getDetail(@Param("id") String id);
}
