package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iris.model.entity.RoleInOrganization;
import com.iris.model.mapper.RoleInOrganizationMapper;
import com.iris.service.IRoleInOrganizationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与机构关系表 服务实现类
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-28
 */
@Service
public class RoleInOrganizationServiceImpl extends ServiceImpl<RoleInOrganizationMapper, RoleInOrganization> implements IRoleInOrganizationService {

}
