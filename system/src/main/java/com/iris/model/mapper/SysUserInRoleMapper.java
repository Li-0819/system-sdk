package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysUserInRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface SysUserInRoleMapper extends BaseMapper<SysUserInRole> {

}
