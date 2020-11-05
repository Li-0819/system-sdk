package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysAppVersion;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 应用版本信息 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface SysAppVersionMapper extends BaseMapper<SysAppVersion> {

}
