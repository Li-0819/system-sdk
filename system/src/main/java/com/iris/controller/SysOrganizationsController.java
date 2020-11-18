package com.iris.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOrganizationsEditDTO;
import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.entity.OrganizationExtraInfo;
import com.iris.model.vo.system.SysOrganizationsListVO;
import com.iris.service.IOrganizationExtraInfoService;
import com.iris.service.ISysOrganizationsService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.models.auth.In;
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

    @Resource private IOrganizationExtraInfoService iOrganizationExtraInfoService;

    @SystemLog(description = "获取组织机构列表")
    @Operation(summary = "获取组织机构列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysOrganizationsListVO>> getList(SysOrganizationsListDTO sysOrganizationsListDTO){

        PageConditionUtil.checkDefaultPage(sysOrganizationsListDTO);

        PageResponseVO<SysOrganizationsListVO> pageResponseVO = iSysOrganizationsService.getList(sysOrganizationsListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑组织机构列表")
    @Operation(summary = "编辑组织机构列表 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysOrganizationsEditDTO sysOrganizationsEditDTO){

       if (iSysOrganizationsService.checkRepeat(
                sysOrganizationsEditDTO.getId(),
                sysOrganizationsEditDTO.getParentId(),
                sysOrganizationsEditDTO.getCode(),
                sysOrganizationsEditDTO.getName(),
                sysOrganizationsEditDTO.getOrganizationExtraInfoEditDTO().getIsPlatform()
                )){

            return ResponseVO.error(SystemMsgConstants.CODE_OR_NAME_NOT_REPEAT);
        }

       iSysOrganizationsService.edit(sysOrganizationsEditDTO);

       return ResponseVO.ok(SystemMsgConstants.SYS_ORGANIZATIONS_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取组织机构详情")
    @Operation(summary = "获取组织机构详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysOrganizationsListVO> getDetail(@PathVariable String id){

        SysOrganizationsListVO sysOrganizations = iSysOrganizationsService.getDetail(id);

        return ResponseVO.ok(sysOrganizations);
    }

    @SystemLog(description = "删除组织机构")
    @Operation(summary = "删除组织机构 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysOrganizationsService.removeById(id);

        QueryWrapper<OrganizationExtraInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SystemCommonField.ORGANIZATION_ID, id);
        iOrganizationExtraInfoService.remove(queryWrapper);

        return ResponseVO.ok(SystemMsgConstants.SYS_ORGANIZATIONS_DELETE_SUCCESS);
    }

    @SystemLog(description = "审核组织机构信息")
    @Operation(summary = "审核组织机构信息 -- WindChaser", tags = "Organization")
    @GetMapping("/audit")
    public ResponseVO<?> audit(@RequestParam("id") String id, @RequestParam("status") String status){


        iSysOrganizationsService.audit(id, status);

        return ResponseVO.ok();
    }

    @Operation(summary = "是否开启企业包车 -- WindChaser", tags = "Organization")
    @GetMapping("/updateIsCharterByOrgId")
    public ResponseVO<?> updateIsCharterByOrgId(@RequestParam(name = "orgId") String orgId,
                                                @RequestParam(name = "isCharter") Integer isCharter) {

        iSysOrganizationsService.updateIsCharterByOrgId(orgId, isCharter);

        return ResponseVO.ok();
    }
}
