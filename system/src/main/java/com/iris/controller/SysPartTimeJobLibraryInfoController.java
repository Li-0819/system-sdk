package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoEditDTO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoListDTO;
import com.iris.model.vo.system.SysPartTimeJobLibraryInfoVO;
import com.iris.service.ISysPartTimeJobLibraryInfoService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 职位描述素材库信息 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "职位描述素材库信息")
@RestController
@RequestMapping("/system/partTimeJobLibraryInfo")
public class SysPartTimeJobLibraryInfoController {

    @Resource private ISysPartTimeJobLibraryInfoService iSysPartTimeJobLibraryInfoService;

    @Operation(summary = "获取职位描述素材库列表 -- WindChaser", tags = "System")
    @PostMapping("/getList")
    public ResponseVO<PageResponseVO<SysPartTimeJobLibraryInfoVO>> getList(@RequestBody SysPartTimeJobLibraryInfoListDTO listDTO){

        PageConditionUtil.checkDefaultPage(listDTO);

        return ResponseVO.ok(iSysPartTimeJobLibraryInfoService.getList(listDTO));
    }

    @Operation(summary = "获取职位描述素材库详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysPartTimeJobLibraryInfoVO> getDetail(@PathVariable String id){

        return ResponseVO.ok(iSysPartTimeJobLibraryInfoService.getDetail(id));
    }

    @Operation(summary = "编辑职位描述素材库信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@RequestBody @Valid SysPartTimeJobLibraryInfoEditDTO editDTO){

        iSysPartTimeJobLibraryInfoService.edit(editDTO);

        return ResponseVO.ok();
    }

    @Operation(summary = "删除职位描述素材库 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysPartTimeJobLibraryInfoService.removeById(id);

        return ResponseVO.ok();
    }

}
