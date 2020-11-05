package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.organization.OrganizationExtraInfoEditDTO;
import com.iris.model.dto.organization.OrganizationExtraInfoListDTO;
import com.iris.model.vo.organization.OrganizationExtraInfoDetailVO;
import com.iris.model.vo.organization.OrganizationExtraInfoListVO;
import com.iris.service.IOrganizationExtraInfoService;
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
 * 机构附属信息 前端控制器
 * </p>
 *
 * @author amaterasu
 * @since 2020-09-18
 */
@Tag(name = "Organization", description = "机构附属信息")
@RestController
@RequestMapping("/organization/extraInfo")
public class OrganizationExtraInfoController {

    @Resource
    private IOrganizationExtraInfoService iOrganizationExtraInfoService;

    @SystemLog(description = "获取机构信息列表")
    @Operation(summary = "获取机构信息列表 -- WindChaser", tags = "Organization")
    @PostMapping("/getList")
    public ResponseVO<PageResponseVO<OrganizationExtraInfoListVO>> getList(@RequestBody OrganizationExtraInfoListDTO organizationInfoListDTO){

        PageConditionUtil.checkDefaultPage(organizationInfoListDTO);

        PageResponseVO<OrganizationExtraInfoListVO> pageResponseVO = iOrganizationExtraInfoService.getList(organizationInfoListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "获取机构信息详情")
    @Operation(summary = "获取机构信息详情 -- WindChaser", tags = "Organization")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<OrganizationExtraInfoDetailVO> getDetail(@PathVariable String id){

        OrganizationExtraInfoDetailVO vo = iOrganizationExtraInfoService.getDetail(id);

        return ResponseVO.ok(vo);
    }

    @SystemLog(description = "删除组织机构信息")
    @Operation(summary = "删除组织机构信息 -- WindChaser", tags = "Organization")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iOrganizationExtraInfoService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.ORGANIZATION_INFO_DELETE_SUCCESS);
    }

    @SystemLog(description = "编辑组织机构信息")
    @Operation(summary = "编辑组织机构信息 -- WindChaser", tags = "Organization")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody OrganizationExtraInfoEditDTO organizationInfoEditDTO){

        if (iOrganizationExtraInfoService.checkRepeat(organizationInfoEditDTO.getId(), organizationInfoEditDTO.getUnifiedCreditCode())){

            return ResponseVO.error(SystemMsgConstants.UNIFIED_CREDIT_CODE_NOT_REPEAT);
        }

        iOrganizationExtraInfoService.edit(organizationInfoEditDTO);

        return ResponseVO.ok(SystemMsgConstants.ORGANIZATION_INFO_EDIT_SUCCESS);
    }

    @SystemLog(description = "审核组织机构信息")
    @Operation(summary = "审核组织机构信息 -- WindChaser", tags = "Organization")
    @GetMapping("/audit")
    public ResponseVO<?> audit(@RequestParam("id") String id, @RequestParam("status") String status){

        iOrganizationExtraInfoService.audit(id, status);

        return ResponseVO.ok(SystemMsgConstants.ORGANIZATION_AUDIT_SUCCESS);
    }

}
