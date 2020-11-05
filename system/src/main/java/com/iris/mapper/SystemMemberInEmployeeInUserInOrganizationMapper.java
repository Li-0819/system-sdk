package com.iris.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.MemberInEmployeeInUserInOrganization;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员与员工与用户与组织机构关系表 Mapper 接口
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-21
 */
@Mapper
public interface SystemMemberInEmployeeInUserInOrganizationMapper extends BaseMapper<MemberInEmployeeInUserInOrganization> {

}
