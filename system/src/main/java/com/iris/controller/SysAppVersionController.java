package com.iris.controller;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppVersionEditDTO;
import com.iris.model.dto.system.SysAppVersionListDTO;
import com.iris.model.vo.system.SysAppVersionVO;
import com.iris.service.ISysAppVersionService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 应用版本信息 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/appVersion")
public class SysAppVersionController {

    @Resource private ISysAppVersionService iSysAppVersionService;

    @SystemLog(description = "获取应用版本信息列表")
    @Operation(summary = "获取应用版本信息列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysAppVersionVO>> getList(SysAppVersionListDTO sysAppVersionListDTO) {

        PageConditionUtil.checkDefaultPage(sysAppVersionListDTO);

        PageResponseVO<SysAppVersionVO> pageResponseVO = iSysAppVersionService.getList(sysAppVersionListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑应用版本信息")
    @Operation(summary = "编辑应用版本信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@RequestBody SysAppVersionEditDTO sysAppVersionEditDTO){

        if (iSysAppVersionService.checkRepeat(sysAppVersionEditDTO.getAppName(),sysAppVersionEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.APP_NAME_NOT_REPEAT);
        }

        iSysAppVersionService.edit(sysAppVersionEditDTO);

        return ResponseVO.ok(SystemMsgConstants.APP_VERSION_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取应用版本信息详情")
    @Operation(summary = "获取应用版本信息详情 --WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysAppVersionVO> getDetail(@PathVariable String id){

        SysAppVersionVO sysAppVersionVO = iSysAppVersionService.getDetail(id);

        return ResponseVO.ok(sysAppVersionVO);
    }

    @SystemLog(description = "删除应用版本信息")
    @Operation(summary = "删除应用版本信息 --WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysAppVersionService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.APP_VERSION_DELETE_SUCCESS);
    }
}
