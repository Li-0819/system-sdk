package com.iris.mapper;

import com.iris.model.dto.organization.OrganizationExtraInfoListDTO;
import com.iris.model.vo.organization.OrganizationExtraInfoDetailVO;
import com.iris.model.vo.organization.OrganizationExtraInfoListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOrganizationExtraInfoMapper {

    /**
     * 获取机构信息列表
     * @param organizationExtraInfoListDTO {@link OrganizationExtraInfoListDTO}
     * @return
     */
    List<OrganizationExtraInfoListVO> getList(@Param("organizationExtraInfoListDTO") OrganizationExtraInfoListDTO organizationExtraInfoListDTO);

    /**
     * 获取机构信息详情
     * @param id 机构信息ID
     * @param parentId 父级Id
     * @return
     */
    OrganizationExtraInfoDetailVO getDetail(@Param("id") String id, @Param("parentId")String parentId);

    /**
     * 审核
     * @param id 机构ID
     * @param status 状态
     */
    void audit(@Param("id") String id, @Param("status") String status);
}
