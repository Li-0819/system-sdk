package com.iris.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iris.mapper.SystemMemberInEmployeeInUserInOrganizationMapper;
import com.iris.model.entity.MemberInEmployeeInUserInOrganization;
import com.iris.service.IMemberInEmployeeInUserInOrganizationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员与员工与用户与组织机构关系表 服务实现类
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-21
 */
@Service
public class MemberInEmployeeInUserInOrganizationServiceImpl extends ServiceImpl<SystemMemberInEmployeeInUserInOrganizationMapper, MemberInEmployeeInUserInOrganization> implements IMemberInEmployeeInUserInOrganizationService {

}
