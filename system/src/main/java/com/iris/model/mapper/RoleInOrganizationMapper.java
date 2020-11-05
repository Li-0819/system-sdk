package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.RoleInOrganization;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与机构关系表 Mapper 接口
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-28
 */
@Mapper
public interface RoleInOrganizationMapper extends BaseMapper<RoleInOrganization> {

}
