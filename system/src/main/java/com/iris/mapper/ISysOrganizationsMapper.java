package com.iris.mapper;


import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.vo.system.SysOrganizationsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-31 18:04
 * @description NAME
 */
@Mapper
public interface ISysOrganizationsMapper {

    /**
     * 组织机构表
     * @param sysOrganizationsListDTO
     * @return
     */
    List<SysOrganizationsVO> getList(@Param("sysOrganizationsListDTO") SysOrganizationsListDTO sysOrganizationsListDTO);


    /**
     * 获取组织机构详情
     * @param id
     * @param parentId
     * @return
     */
    SysOrganizationsVO getDetail(@Param("id") String id, @Param("parentId") String parentId);
}
