package com.iris.controller;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.UserEditDTO;
import com.iris.model.dto.system.UserListDTO;
import com.iris.model.entity.SysUsers;
import com.iris.model.vo.system.UsersDetailVO;
import com.iris.model.vo.system.UsersListVO;
import com.iris.service.ISysUsersService;
import com.iris.utils.common.PageConditionUtil;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Tag(name = "System", description = "系统设置")
@RestController
@RequestMapping("/system/sysUsers")
public class SysUsersController {

    @Resource private ISysUsersService isysUsersService;

    @SystemLog(description = "查询用户信息列表")
    @Operation(summary = "查询用户信息列表 -- WindChaser", tags = "System")
    @GetMapping("/getList")
    public ResponseVO<PageResponseVO<UsersListVO>> getList(UserListDTO userListDTO){

        PageConditionUtil.checkDefaultPage(userListDTO);

        PageResponseVO<UsersListVO> pageResponseVO = isysUsersService.getList(userListDTO);

        return ResponseVO.ok(pageResponseVO);
    }

    @SystemLog(description = "编辑用户信息")
    @Operation(summary = "编辑用户信息 -- WindChaser", tags = "System")
    @PostMapping("/edit")
    public ResponseVO<?> edit(@Valid @RequestBody UserEditDTO userEditDTO){

        if (isysUsersService.checkLoginNameRepeat(userEditDTO.getLoginName(), userEditDTO.getId())){

            return ResponseVO.error(SystemMsgConstants.USER_LOGIN_NAME_REPEAT);
        }

        isysUsersService.edit(userEditDTO);

        return ResponseVO.ok(SystemMsgConstants.USER_EDIT_SUCCESS);
    }

    @SystemLog(description = "获取用户详情信息")
    @Operation(summary = "获取用户详情信息 -- WindChaser", tags = "System")
    @GetMapping("/getDetail/{id}")
    public ResponseVO<UsersDetailVO> getDetail(@PathVariable String id){

        UsersDetailVO usersDetailVO = isysUsersService.getDetail(id);

        return ResponseVO.ok(usersDetailVO);
    }

    @SystemLog(description = "删除用户信息")
    @Operation(summary = "删除用户信息 -- WindChaser", tags = "System")
    @DeleteMapping("/delete/{id}")
    public ResponseVO<UsersDetailVO> delete(@PathVariable String id){

        SysUsers one = isysUsersService.getById(id);

        if (one.getLoginName().equals(SystemCommonField.ADMIN)){

            return ResponseVO.error(SystemMsgConstants.ADMIN_NOT_DELETE);
        }

        isysUsersService.removeById(id);

        return ResponseVO.ok(SystemMsgConstants.USER_DELETE_SUCCESS);
    }
}
