package com.iris.mapper;


import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.vo.system.SysOrganizationsListVO;
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
    List<SysOrganizationsListVO> getList(@Param("sysOrganizationsListDTO") SysOrganizationsListDTO sysOrganizationsListDTO);


    /**
     * 获取组织机构详情
     * @param id
     * @param parentId
     * @return
     */
    SysOrganizationsListVO getDetail(@Param("id") String id, @Param("parentId") String parentId);

    /**
     * 校验组织机构相同parentId下是否有重复名称或者编码
     * @param id 组织机构ID
     * @param parentId 父节点ID
     * @param code 编码
     * @param name 名称
     * @return
     */
    Integer checkRepeat(String id, String parentId, String code, String name);

    /**
     * 修改机构信息锁定状态
     * @param id ID
     * @param isLocked 是否锁定
     */
    void updateIsLockedById(@Param("id")String id, @Param("isLocked") Integer isLocked);
}
