package com.iris.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysSmsSendCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 验证码管理 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface SysSmsSendCodeMapper extends BaseMapper<SysSmsSendCode> {

}
