package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysIntegralSettingInfoEditDTO;
import com.iris.model.dto.system.SysIntegralSettingInfoListDTO;
import com.iris.model.entity.SysIntegralSettingInfo;
import com.iris.model.vo.system.SysIntegralSettingInfoVO;
import com.iris.service.ISysIntegralSettingInfoService;
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
 * 积分配置信息 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "会员特权卡设置")
@RestController
@RequestMapping("/system/integralSettingInfo")
public class SysIntegralSettingInfoController {

    @Resource private ISysIntegralSettingInfoService iSysIntegralSettingInfoService;

    @Operation(summary = "获取积分配置信息列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysIntegralSettingInfoVO>> getList(SysIntegralSettingInfoListDTO sysIntegralSettingInfoListDTO){

        PageConditionUtil.checkDefaultPage(sysIntegralSettingInfoListDTO);

        PageResponseVO<SysIntegralSettingInfoVO> pageResponseVO = iSysIntegralSettingInfoService.getList(sysIntegralSettingInfoListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑积分配置信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysIntegralSettingInfoEditDTO sysIntegralSettingInfoEditDTO){

        if (iSysIntegralSettingInfoService.checkNameAndCodeRepeat(
                sysIntegralSettingInfoEditDTO.getIntegralName(),
                sysIntegralSettingInfoEditDTO.getIntegralCode(),
                sysIntegralSettingInfoEditDTO.getId()
        )){

            return ResponseVO.error(SystemMsgConstants.EXIST_SAME_INTEGRAL_NAME_CODE_DATA);
        }

        iSysIntegralSettingInfoService.edit(sysIntegralSettingInfoEditDTO);

        return ResponseVO.ok(SystemMsgConstants.INTEGRAL_SETTING_EDIT_SUCCESS);
    }

    @Operation(summary = "获取积分配置详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysIntegralSettingInfoVO> getDetail(@PathVariable String id){

        return ResponseVO.ok(iSysIntegralSettingInfoService.getDetail(id));
    }

    @Operation(summary = "删除积分配置信息 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysIntegralSettingInfoService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.INTEGRAL_SETTING_DELETE_SUCCESS);
    }
}
