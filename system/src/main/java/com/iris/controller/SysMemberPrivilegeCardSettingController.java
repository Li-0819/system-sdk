package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingEditDTO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingListDTO;
import com.iris.model.vo.system.SysMemberPrivilegeCardSettingVO;
import com.iris.service.ISysMemberPrivilegeCardSettingService;
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
 * 会员特权卡设置 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "会员特权卡设置")
@RestController
@RequestMapping("/system/memberPrivilegeCardSetting")
public class SysMemberPrivilegeCardSettingController {

    @Resource private ISysMemberPrivilegeCardSettingService iSysMemberPrivilegeCardSettingService;

    @Operation(summary = "获取会员特权卡列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysMemberPrivilegeCardSettingVO>> getList(SysMemberPrivilegeCardSettingListDTO sysMemberPrivilegeCardSettingListDTO){

        PageConditionUtil.checkDefaultPage(sysMemberPrivilegeCardSettingListDTO);

        PageResponseVO<SysMemberPrivilegeCardSettingVO> pageResponseVO = iSysMemberPrivilegeCardSettingService.getList(sysMemberPrivilegeCardSettingListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑会员特权卡 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysMemberPrivilegeCardSettingEditDTO sysMemberPrivilegeCardSettingEditDTO){

        if (iSysMemberPrivilegeCardSettingService.checkTypeRepeat(sysMemberPrivilegeCardSettingEditDTO.getType(),sysMemberPrivilegeCardSettingEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.MEMBER_PRIVILEGE_CARD_TYPE_NOT_REPEAT);
        }

        iSysMemberPrivilegeCardSettingService.edit(sysMemberPrivilegeCardSettingEditDTO);

        return ResponseVO.ok(SystemMsgConstants.MEMBER_PRIVILEGE_CARD_EDIT_SUCCESS);
    }

    @Operation(summary = "获取会员特权卡详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysMemberPrivilegeCardSettingVO> getDetail(@PathVariable String id){

        SysMemberPrivilegeCardSettingVO signInMoodLibraryInfoVO = iSysMemberPrivilegeCardSettingService.getDetail(id);

        return ResponseVO.ok(signInMoodLibraryInfoVO);
    }

    @Operation(summary = "删除会员特权卡 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysMemberPrivilegeCardSettingService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.MEMBER_PRIVILEGE_CARD_DELETE_SUCCESS);
    }
}
