package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoListDTO;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoVO;
import com.iris.service.ISysSignInMoodLibraryInfoService;
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
 * 签到心情图文素材库 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "签到心情图文素材库")
@RestController
@RequestMapping("/system/signInMoodLibraryInfo")
public class SysSignInMoodLibraryInfoController {

    @Resource private ISysSignInMoodLibraryInfoService iSysSignInMoodLibraryInfoService;

    @Operation(summary = "获取签到心情图文素材库列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysSignInMoodLibraryInfoVO>> getList(SysSignInMoodLibraryInfoListDTO sysSignInMoodLibraryInfoListDTO){

        PageConditionUtil.checkDefaultPage (sysSignInMoodLibraryInfoListDTO);

        PageResponseVO<SysSignInMoodLibraryInfoVO> pageResponseVO = iSysSignInMoodLibraryInfoService.getList(sysSignInMoodLibraryInfoListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @Operation(summary = "编辑签到心情图文素材库 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysSignInMoodLibraryInfoEditDTO sysSignInMoodLibraryInfoEditDTO){

        if (iSysSignInMoodLibraryInfoService.checkNameRepeat(sysSignInMoodLibraryInfoEditDTO.getLibraryName(), sysSignInMoodLibraryInfoEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.LIBRARY_NAME_NOT_REPEAT);
        }

        iSysSignInMoodLibraryInfoService.edit(sysSignInMoodLibraryInfoEditDTO);

        return ResponseVO.ok(SystemMsgConstants.COMMODITY_LIBRARY_EDIT_SUCCESS);
    }

    @Operation(summary = "获取签到心情图文素材库详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysSignInMoodLibraryInfoVO> getDetail(@PathVariable String id){

        return ResponseVO.ok(iSysSignInMoodLibraryInfoService.getDetail(id));
    }

    @Operation(summary = "删除签到心情图文素材库 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysSignInMoodLibraryInfoService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.COMMODITY_LIBRARY_DELETE_SUCCESS);
    }
}
