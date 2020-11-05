package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysOperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台系统操作记录 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface SysOperationLogMapper extends BaseMapper<SysOperationLog> {

}
