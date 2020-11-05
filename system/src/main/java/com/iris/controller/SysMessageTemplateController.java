package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMessageTemplateEditDTO;
import com.iris.model.dto.system.SysMessageTemplateListDTO;
import com.iris.model.vo.system.SysMessageTemplateVO;
import com.iris.service.ISysMessageTemplateService;
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
 * 消息模版库 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "消息模版")
@RestController
@RequestMapping("/system/messageTemplate")
public class SysMessageTemplateController {

    @Resource private ISysMessageTemplateService iSysMessageTemplateService;

    @SystemLog(description = "获取消息模版列表")
    @Operation(summary = "获取消息模版列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysMessageTemplateVO>> getList(SysMessageTemplateListDTO sysMessageTemplateListDTO){

        PageConditionUtil.checkDefaultPage(sysMessageTemplateListDTO);

        PageResponseVO<SysMessageTemplateVO> pageList =  iSysMessageTemplateService.getList(sysMessageTemplateListDTO);

        return ResponseVO.ok(pageList);
    }

    @SystemLog(description = "编辑消息模板")
    @Operation(summary = "编辑消息模板 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysMessageTemplateEditDTO sysMessageTemplateEditDTO){

        if (iSysMessageTemplateService.checkCodeRepeat(sysMessageTemplateEditDTO.getCode(), sysMessageTemplateEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.CODE_NOT_REPEAT);
        }

        iSysMessageTemplateService.edit(sysMessageTemplateEditDTO);

        return ResponseVO.ok(SystemMsgConstants.SMS_EDIT_SUCCESS);
    }

    @SystemLog(description = "删除消息模板")
    @Operation(summary = "删除消息模板 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysMessageTemplateService.delete(id);

        return ResponseVO.ok(SystemMsgConstants.SMS_DELETE_SUCCESS);
    }

    @SystemLog(description = "获取消息模板详情")
    @Operation(summary = "获取消息模板详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysMessageTemplateVO> getDetail(@PathVariable String id) {

        return ResponseVO.ok(iSysMessageTemplateService.getDetail(id));
    }
}
