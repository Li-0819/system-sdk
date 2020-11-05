package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysActionEditDTO;
import com.iris.model.dto.system.SysActionListDTO;
import com.iris.model.vo.system.SysActionVO;
import com.iris.service.ISysActionService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 功能管理 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/action")
public class SysActionController {

    @Resource private ISysActionService iSysActionService;

    @SystemLog(description = "获取功能管理列表")
    @Operation(summary = "获取功能管理列表 -- RubyWong", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysActionVO>> getList(SysActionListDTO sysActionListDTO){

        PageConditionUtil.checkDefaultPage(sysActionListDTO);

        PageResponseVO<SysActionVO> pageResult = iSysActionService.getList(sysActionListDTO);

        return ResponseVO.ok(pageResult);
    }

    @SystemLog(description = "获取功能管理列表")
    @Operation(summary = "编辑按钮功能 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysActionEditDTO sysActionEditDTO){

        if (iSysActionService.checkKeyRepeat(sysActionEditDTO.getKey(), sysActionEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.ACTION_KEY_NOT_REPEAT);
        }

        iSysActionService.edit(sysActionEditDTO);

        return ResponseVO.ok(SystemMsgConstants.ACTION_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取功能管理详情")
    @Operation(summary = "获取功能管理详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysActionVO> getDetail(@PathVariable String id){

        SysActionVO sysActionVO = iSysActionService.getDetail(id);

        return ResponseVO.ok(sysActionVO);
    }

    @SystemLog(description = "删除功能管理")
    @Operation(summary = "删除功能管理 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysActionService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.ACTION_DELETE_SUCCESS);
    }
}
