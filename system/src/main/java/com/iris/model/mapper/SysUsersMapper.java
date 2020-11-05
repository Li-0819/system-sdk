package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysUsers;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface SysUsersMapper extends BaseMapper<SysUsers> {

}
