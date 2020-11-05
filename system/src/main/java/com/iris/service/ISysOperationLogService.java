package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOperationLogListDTO;
import com.iris.model.entity.SysOperationLog;
import com.iris.model.vo.system.SysOperationLogVO;

/**
 * <p>
 * 后台系统操作记录 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysOperationLogService extends IService<SysOperationLog> {

    /**
     * 获取后台系统操作记录列表
     * @param sysOperationLogListDTO {@link SysOperationLogListDTO}
     * @return
     */
    PageResponseVO<SysOperationLogVO> getList(SysOperationLogListDTO sysOperationLogListDTO);
}
