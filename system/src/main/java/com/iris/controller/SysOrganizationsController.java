package com.iris.controller;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOrganizationsEditDTO;
import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.vo.system.SysOrganizationsVO;
import com.iris.service.ISysOrganizationsService;
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
 * 组织机构表 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/organizations")
public class SysOrganizationsController {

    @Resource private ISysOrganizationsService iSysOrganizationsService;

    @SystemLog(description = "获取组织机构列表")
    @Operation(summary = "获取组织机构列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysOrganizationsVO>> getList(SysOrganizationsListDTO sysOrganizationsListDTO){

        PageConditionUtil.checkDefaultPage(sysOrganizationsListDTO);

        PageResponseVO<SysOrganizationsVO> pageResponseVO = iSysOrganizationsService.getList(sysOrganizationsListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑组织机构列表")
    @Operation(summary = "编辑组织机构列表 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<SysOrganizationsVO> edit(@Valid @RequestBody SysOrganizationsEditDTO sysOrganizationsEditDTO){

       if (iSysOrganizationsService.checkRepeat(
                sysOrganizationsEditDTO.getId(),
                sysOrganizationsEditDTO.getParentId(),
                sysOrganizationsEditDTO.getCode(),
                sysOrganizationsEditDTO.getName()
                )){

            return ResponseVO.error(SystemMsgConstants.CODE_OR_NAME_NOT_REPEAT);
        }

       iSysOrganizationsService.edit(sysOrganizationsEditDTO);

       return ResponseVO.ok(SystemMsgConstants.SYS_ORGANIZATIONS_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取组织机构详情")
    @Operation(summary = "获取组织机构详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysOrganizationsVO> getDetail(@PathVariable String id){

        SysOrganizationsVO sysOrganizations = iSysOrganizationsService.getDetail(id);

        return ResponseVO.ok(sysOrganizations);
    }

    @SystemLog(description = "删除组织机构")
    @Operation(summary = "删除组织机构 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysOrganizationsService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.SYS_ORGANIZATIONS_DELETE_SUCCESS);
    }
}
