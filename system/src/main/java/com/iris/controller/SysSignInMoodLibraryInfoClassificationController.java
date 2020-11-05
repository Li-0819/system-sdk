package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationListDTO;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoClassificationVO;
import com.iris.service.ISysSignInMoodLibraryInfoClassificationService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 签到心情图文素材库分类 前端控制器
 * </p>
 *
 * @author WindChaser
 * @since 2020-07-27
 */
@Slf4j
@Tag(name = "System", description = "签到心情图文素材库分类")
@RestController
@RequestMapping("/system/signInMoodLibraryInfoClassification")
public class SysSignInMoodLibraryInfoClassificationController {

    @Resource private ISysSignInMoodLibraryInfoClassificationService iSysSignInMoodLibraryInfoClassificationService;

    @Operation(summary = "获取心情图文素材库分类 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysSignInMoodLibraryInfoClassificationVO>> getList(SysSignInMoodLibraryInfoClassificationListDTO sysSignInMoodLibraryInfoClassificationListDTO){

        PageConditionUtil.checkDefaultPage(sysSignInMoodLibraryInfoClassificationListDTO);

        PageResponseVO<SysSignInMoodLibraryInfoClassificationVO> pageResponseVO =  iSysSignInMoodLibraryInfoClassificationService.getList(sysSignInMoodLibraryInfoClassificationListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑心情图文素材库分类 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysSignInMoodLibraryInfoClassificationEditDTO sysSignInMoodLibraryInfoClassificationEditDTO){

        if (iSysSignInMoodLibraryInfoClassificationService.checkRepeat(
                sysSignInMoodLibraryInfoClassificationEditDTO.getName(),
                sysSignInMoodLibraryInfoClassificationEditDTO.getCode(),
                sysSignInMoodLibraryInfoClassificationEditDTO.getId()
        )){

            return ResponseVO.error(SystemMsgConstants.CODE_OR_NAME_NOT_REPEAT);
        }

        iSysSignInMoodLibraryInfoClassificationService.edit(sysSignInMoodLibraryInfoClassificationEditDTO);

        return ResponseVO.ok(SystemMsgConstants.COMMODITY_LIBRARY_TYPE_EDIT_SUCCESS);
    }

    @Operation(summary = "获取心情图文素材库分类详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysSignInMoodLibraryInfoClassificationVO> getDetail(@ApiParam(name = "id", value = "素材库分类ID", required = true) @PathVariable String id){

        return ResponseVO.ok(iSysSignInMoodLibraryInfoClassificationService.getDetail(id));
    }

    @Operation(summary = "删除心情图文素材库分类 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@ApiParam(name = "id", value = "素材库分类ID", required = true) @PathVariable String id){

        iSysSignInMoodLibraryInfoClassificationService.removeById(id);

        return  ResponseVO.ok(SystemMsgConstants.COMMODITY_LIBRARY_TYPE_DELETE_SUCCESS);
    }
}
