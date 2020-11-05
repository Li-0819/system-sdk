package com.iris.controller;


import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPositionEditDTO;
import com.iris.model.dto.system.SysPositionListDTO;
import com.iris.model.vo.system.SysPositionVO;
import com.iris.service.ISysPositionService;
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
 * 职位信息表 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/position")
public class SysPositionController {

    @Resource private ISysPositionService iSysPositionService;

    @SystemLog(description = "获取职位信息表列表")
    @Operation(summary = "获取职位信息表列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysPositionVO>> getList(SysPositionListDTO sysPositionListDTO){

        PageConditionUtil.checkDefaultPage(sysPositionListDTO);

        PageResponseVO<SysPositionVO> pageResponseVO = iSysPositionService.getList(sysPositionListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑职位信息")
    @Operation(summary = "编辑职位信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysPositionEditDTO sysPositionEditDTO){

        if (iSysPositionService.checkRepeat(
                sysPositionEditDTO.getId(),
                sysPositionEditDTO.getOrganizationsId(),
                sysPositionEditDTO.getPositionName())){

            return ResponseVO.error(SystemMsgConstants.EXIST_SAME_INTEGRAL_NAME_CODE_DATA);
        }

        iSysPositionService.edit(sysPositionEditDTO);

        return ResponseVO.ok(SystemMsgConstants.SYS_POSITION_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取职位信息详情")
    @Operation(summary = "获取职位信息详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysPositionVO> getDetail(@PathVariable String id){

        SysPositionVO sysPositionVO = iSysPositionService.getDetail(id);

        return ResponseVO.ok(sysPositionVO);
    }

    @SystemLog(description = "删除职位信息")
    @Operation(summary = "删除职位信息 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id){

        iSysPositionService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.SYS_POSITION_DELETE_SUCCESS);
    }
}
