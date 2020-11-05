package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysOperationLogMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOperationLogListDTO;
import com.iris.model.entity.SysOperationLog;
import com.iris.model.mapper.SysOperationLogMapper;
import com.iris.model.vo.system.SysOperationLogVO;
import com.iris.service.ISysOperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台系统操作记录 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

    @Resource private ISysOperationLogMapper iSysOperationLogMapper;
    /**
     * 获取后台系统操作记录列表
     * @param sysOperationLogListDTO {@link SysOperationLogListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysOperationLogVO> getList(SysOperationLogListDTO sysOperationLogListDTO) {

        PageHelper.startPage(sysOperationLogListDTO.getCurrentPage(), sysOperationLogListDTO.getPageSize());

        List<SysOperationLogVO> list = iSysOperationLogMapper.getList(sysOperationLogListDTO);

        return PageResponseVO.of(list, SysOperationLogVO.class);
    }
}
