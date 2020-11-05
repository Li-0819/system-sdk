package com.iris.controller;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysBannerEditDTO;
import com.iris.model.dto.system.SysBannerListDTO;
import com.iris.model.vo.system.SysBannerVO;
import com.iris.service.ISysBannerService;
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
 * banner信息 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/banner")
public class SysBannerController {

    @Resource private ISysBannerService iSysBannerService;

    @SystemLog(description = "获取banner信息列表")
    @Operation(summary = "获取banner信息列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysBannerVO>> getList(SysBannerListDTO sysBannerListDTO){

        PageConditionUtil.checkDefaultPage(sysBannerListDTO);

        PageResponseVO<SysBannerVO> pageResponseVO = iSysBannerService.getList(sysBannerListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑banner信息")
    @Operation(summary = "编辑banner信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysBannerEditDTO sysBannerEditDTO){

        iSysBannerService.edit(sysBannerEditDTO);

        return ResponseVO.ok(SystemMsgConstants.BANNER_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取banner信息详情")
    @Operation(summary = "获取banner信息详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysBannerVO> getDetail(@PathVariable String id) {

         SysBannerVO sysBannerVO = iSysBannerService.getDetail(id);

         return ResponseVO.ok(sysBannerVO);
    }

    @SystemLog(description = "删除banner信息")
    @Operation(summary = "删除banner信息 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id) {

        iSysBannerService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.BANNER_DELETE_SUCCESS);
    }
}
