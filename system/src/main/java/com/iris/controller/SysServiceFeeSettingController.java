package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysServiceFeeSettingEditDTO;
import com.iris.model.dto.system.SysServiceFeeSettingListDTO;
import com.iris.model.vo.system.SysServiceFeeSettingVO;
import com.iris.service.ISysServiceFeeSettingService;
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
 * 服务费分润比例设置 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "服务费分润比例设置")
@RestController
@RequestMapping("/system/serviceFeeSetting")
public class SysServiceFeeSettingController {

    @Resource private ISysServiceFeeSettingService iSysServiceFeeSettingService;

    @Operation(summary = "获取服务费分润比例设置列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysServiceFeeSettingVO>> getList(SysServiceFeeSettingListDTO sysServiceFeeSettingListDTO){

        PageConditionUtil.checkDefaultPage(sysServiceFeeSettingListDTO);

        PageResponseVO<SysServiceFeeSettingVO> pageResponseVO = iSysServiceFeeSettingService.getList(sysServiceFeeSettingListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑服务费分润比例设置 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysServiceFeeSettingEditDTO sysServiceFeeSettingEditDTO){

        if (iSysServiceFeeSettingService.checkTypeRepeat(sysServiceFeeSettingEditDTO.getSettingType(), sysServiceFeeSettingEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.TYPE_NOT_REPEAT);
        }

        iSysServiceFeeSettingService.edit(sysServiceFeeSettingEditDTO);

        return ResponseVO.ok(SystemMsgConstants.SERVICE_FEE_EDIT_SUCCESS);
    }

    @Operation(summary = "获取服务费分润比例详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysServiceFeeSettingVO> getDetail(@PathVariable String id){

        return ResponseVO.ok(iSysServiceFeeSettingService.getDetail(id));
    }

    @Operation(summary = "删除服务费分润比例 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<SysServiceFeeSettingVO> delete(@PathVariable String id){

        iSysServiceFeeSettingService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.SERVICE_FEE_DELETE_SUCCESS);
    }
}
