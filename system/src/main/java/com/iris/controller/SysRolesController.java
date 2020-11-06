package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysRolesEditDTO;
import com.iris.model.dto.system.SysRolesListDTO;
import com.iris.model.vo.system.SysRolesVO;
import com.iris.service.ISysRolesService;
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
 * 角色管理 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/roles")
public class SysRolesController {

    @Resource private ISysRolesService iSysRolesService;

    @SystemLog(description = "获取角色管理列表")
    @Operation(summary = "获取角色管理列表 -- WindChaser", tags = "System")
    @GetMapping("getList")
    public ResponseVO<PageResponseVO<SysRolesVO>> getList(SysRolesListDTO sysRolesListDTO){

        PageConditionUtil.checkDefaultPage(sysRolesListDTO);

        PageResponseVO<SysRolesVO> pageResponseVO = iSysRolesService.getList(sysRolesListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑角色")
    @Operation(summary = "编辑角色 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysRolesEditDTO sysRolesEditDTO){

        if (iSysRolesService.checkRepeat(sysRolesEditDTO.getCode(),sysRolesEditDTO.getName(),sysRolesEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.ROLE_HAS_BEEN_USED);
        }

        iSysRolesService.edit(sysRolesEditDTO);

        return ResponseVO.ok(SystemMsgConstants.ROLE_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取角色详情")
    @Operation(summary = "获取角色详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysRolesVO> getDetail(@PathVariable String id){

        SysRolesVO sysRolesVO = iSysRolesService.getDetail(id);

        return ResponseVO.ok(sysRolesVO);
    }

    @SystemLog(description = "删除角色")
    @Operation(summary = "删除角色 --WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysRolesService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.ROLE_DELETE_SUCCESS);
    }
}
