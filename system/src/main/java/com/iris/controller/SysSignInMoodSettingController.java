package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodSettingEditDTO;
import com.iris.model.dto.system.SysSignInMoodSettingListDTO;
import com.iris.model.entity.SysSignInMoodSetting;
import com.iris.model.vo.system.SysSignInMoodSettingVO;
import com.iris.service.ISysSignInMoodSettingService;
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
 * 签到心情配置信息 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "签到心情")
@RestController
@RequestMapping("/system/signInMoodSetting")
public class SysSignInMoodSettingController {

    @Resource private ISysSignInMoodSettingService iSysSignInMoodSettingService;

    @Operation(summary = "获取签到心情配置信息列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysSignInMoodSettingVO>> getList(SysSignInMoodSettingListDTO listDTO){

        PageConditionUtil.checkDefaultPage(listDTO);

        PageResponseVO<SysSignInMoodSettingVO> pageResponseVO = iSysSignInMoodSettingService.getList(listDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑签到心情配置信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysSignInMoodSettingEditDTO sysSignInMoodSettingEditDTO){

        if (iSysSignInMoodSettingService.checkRepeat(sysSignInMoodSettingEditDTO.getMoodName(),
                                                     sysSignInMoodSettingEditDTO.getMoodCode(),
                                                     sysSignInMoodSettingEditDTO.getId())
                                                     ){

            return ResponseVO.error(SystemMsgConstants.SIGN_IN_MOOD_CODE_OR_NAME_NOT_REPEAT);
        }

        iSysSignInMoodSettingService.edit(sysSignInMoodSettingEditDTO);

        return ResponseVO.ok(SystemMsgConstants.SIGN_IN_MOOD_SETTING_EDIT_SUCCESS);
    }

    @Operation(summary = "获取签到心情配置信息详情 --WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysSignInMoodSettingVO> getDetail(@PathVariable String id){

       return ResponseVO.ok(iSysSignInMoodSettingService.getDetail(id));
    }

    @Operation(summary = "删除签到心情配置信息 --WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysSignInMoodSettingService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.SIGN_IN_MOOD_SETTING_DELETE_SUCCESS);
    }
}
