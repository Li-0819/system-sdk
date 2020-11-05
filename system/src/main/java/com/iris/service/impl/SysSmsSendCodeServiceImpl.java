package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iris.model.entity.SysSmsSendCode;
import com.iris.model.mapper.SysSmsSendCodeMapper;
import com.iris.service.ISysSmsSendCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 验证码管理 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysSmsSendCodeServiceImpl extends ServiceImpl<SysSmsSendCodeMapper, SysSmsSendCode> implements ISysSmsSendCodeService {

}
