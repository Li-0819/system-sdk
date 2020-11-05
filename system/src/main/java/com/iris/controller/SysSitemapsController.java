package com.iris.controller;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SitemapsEditDTO;
import com.iris.model.entity.SysSitemaps;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SitemapsVO;
import com.iris.service.ISysSitemapsService;
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
 * 菜单管理 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Slf4j
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/sitemaps")
public class SysSitemapsController {

    @Resource private ISysSitemapsService iSysSitemapsService;

    @Operation(summary = "获取菜单权限列表(数据样例) -- RubyWong", tags = "System")
    @GetMapping("/getAuthList")
    public ResponseVO<PageResponseVO<SitemapsAuthVO>> getAuthList() {

        PageResponseVO<SitemapsAuthVO> pageResult = iSysSitemapsService.getAuthList();

        return ResponseVO.ok(pageResult);
    }

    @SystemLog(description = "获取菜单列表")
    @Operation(summary = "获取菜单列表 -- RubyWong", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<SitemapsVO>> getList(String parentId) {

        PageResponseVO<SitemapsVO> pageResult = iSysSitemapsService.getList(parentId);

        return ResponseVO.ok(pageResult);
    }

    @SystemLog(description = "获取菜单详情")
    @Operation(summary = "获取菜单详情 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<SysSitemaps> getDetail(@PathVariable String id){

        SysSitemaps sysSitemaps = iSysSitemapsService.getDetail(id);

        return ResponseVO.ok(sysSitemaps);
    }

    @SystemLog(description = "编辑菜单信息")
    @Operation(summary = "编辑菜单信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody SitemapsEditDTO sitemapsEditDTO){

        if (iSysSitemapsService.checkRepeat(
                sitemapsEditDTO.getId(),
                sitemapsEditDTO.getParentId(),
                sitemapsEditDTO.getName())){

            return ResponseVO.error(SystemMsgConstants.SAME_PARENT_NAME_NOT_REPEAT);
        }

        iSysSitemapsService.edit(sitemapsEditDTO);

        return ResponseVO.ok(SystemMsgConstants.SITE_MAPS_EDIT_SUCCESS);
    }

    @SystemLog(description = "删除菜单信息")
    @Operation(summary = "删除菜单信息 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<?> edit(@PathVariable String id){

        iSysSitemapsService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.SITE_MAPS_DELETE_SUCCESS);
    }
}
