package com.iris.controller;


import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysCodeEditDTO;
import com.iris.model.dto.system.SysCodeListDTO;
import com.iris.model.vo.system.SysCodeVO;
import com.iris.service.ISysCodeService;
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
 * 系统代码 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/code")
public class SysCodeController {

    @Resource private ISysCodeService iSysCodeService;

    @Operation(summary = "获取数据字典列表 -- RubyWong", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SysCodeVO>> getList(SysCodeListDTO sysCodeListDTO) {

        PageConditionUtil.checkDefaultPage(sysCodeListDTO);

        PageResponseVO<SysCodeVO> pageResult = iSysCodeService.getList(sysCodeListDTO);

        return ResponseVO.ok(pageResult);
    }

    @Operation(summary = "编辑数据字典 -- RubyWong", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SysCodeEditDTO sysCodeEditDTO) {

        if (iSysCodeService.checkNameRepeat(sysCodeEditDTO.getName(), sysCodeEditDTO.getType(), sysCodeEditDTO.getId())) {

            return ResponseVO.ok(SystemMsgConstants.NAME_NOT_REPEAT);
        }

        if (iSysCodeService.checkCodeRepeat(sysCodeEditDTO.getCode(), sysCodeEditDTO.getType(), sysCodeEditDTO.getId())) {

            return ResponseVO.ok(SystemMsgConstants.CODE_NOT_REPEAT);
        }

        iSysCodeService.edit(sysCodeEditDTO);

        return ResponseVO.ok(SystemMsgConstants.CODE_EDIT_SUCCESS);
    }

    @Operation(summary = "获取数据字典详情 -- RubyWong", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysCodeVO> getDetail(@PathVariable String id) {

        return ResponseVO.ok(iSysCodeService.getDetail(id));
    }

    @Operation(summary = "删除数据字典信息 -- RubyWong", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> delete(@PathVariable String id) {

        iSysCodeService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.CODE_DELETE_SUCCESS);
    }
}
