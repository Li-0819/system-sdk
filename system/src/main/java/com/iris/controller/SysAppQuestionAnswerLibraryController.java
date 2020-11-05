package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryEditDTO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryListDTO;
import com.iris.model.vo.system.SysAppQuestionAnswerLibraryVO;
import com.iris.service.ISysAppQuestionAnswerLibraryService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * APP答疑资料库 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/appQuestionAnswerLibrary")
public class SysAppQuestionAnswerLibraryController {

    @Resource private ISysAppQuestionAnswerLibraryService iSysAppQuestionAnswerLibraryService;

    @SystemLog(description = "获取APP答疑资料库列表")
    @Operation(summary = "获取APP答疑资料库列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysAppQuestionAnswerLibraryVO>> getList(SysAppQuestionAnswerLibraryListDTO sysAppQuestionAnswerLibraryListDTO){

        PageConditionUtil.checkDefaultPage(sysAppQuestionAnswerLibraryListDTO);

        PageResponseVO<SysAppQuestionAnswerLibraryVO> pageResponseVO = iSysAppQuestionAnswerLibraryService.getList(sysAppQuestionAnswerLibraryListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑APP答疑资料库列表")
    @Operation(summary = "编辑APP答疑资料库列表 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysAppQuestionAnswerLibraryEditDTO sysAppQuestionAnswerLibraryEditDTO){

        iSysAppQuestionAnswerLibraryService.edit(sysAppQuestionAnswerLibraryEditDTO);

        return ResponseVO.ok(SystemMsgConstants.APP_QUESTION_ANSWER_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取APP答疑资料库详情")
    @Operation(summary = "获取APP答疑资料库详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysAppQuestionAnswerLibraryVO> getDetail(@PathVariable String id){

        return ResponseVO.ok(iSysAppQuestionAnswerLibraryService.getDetail(id));
    }

    @SystemLog(description = "删除APP答疑资料库")
    @Operation(summary = "删除APP答疑资料库 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysAppQuestionAnswerLibraryService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.APP_QUESTION_ANSWER_DELETE_SUCCESS);
    }
}
