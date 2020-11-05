package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOperationLogListDTO;
import com.iris.model.vo.system.SysOperationLogVO;
import com.iris.service.ISysOperationLogService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 后台系统操作记录 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/operationLog")
public class SysOperationLogController {

    @Resource private ISysOperationLogService iSysOperationLogService;

    @SystemLog(description = "获取后台系统操作记录列表")
    @Operation(summary = "获取后台系统操作记录列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysOperationLogVO>> getList(SysOperationLogListDTO sysOperationLogListDTO){

        PageConditionUtil.checkDefaultPage(sysOperationLogListDTO);

        PageResponseVO<SysOperationLogVO> pageResponseVO = iSysOperationLogService.getList(sysOperationLogListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "删除后台系统操作记录")
    @Operation(summary = "删除后台系统操作记录 -- WindChaser", tags = "System")
    @PostMapping("/delete")
    public ResponseVO<?> delete(@RequestBody List<String> ids){

        iSysOperationLogService.removeByIds(ids);

        return ResponseVO.ok(SystemMsgConstants.BATCH_DELETE_SUCCESS);
    }
}
