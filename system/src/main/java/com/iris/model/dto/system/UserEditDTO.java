package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-01 17:15
 * @description NAME
 */
@Data
@Schema(name = "UserEditDTO", description = "编辑用户列表")
public class UserEditDTO {

    @Schema(name = "id", description = "用户ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.USER_LOGIN_NAME_NOT_FOUNT)
    @Schema(name = "loginName", description = "登陆名")
    private String loginName;

    @Size(min = 6, max = 16, message = SystemMsgConstants.PASSWORD_LENGTH_ERROR)
    @Schema(name = "loginPwd", description = "登录密码")
    private String loginPwd;

    @NotBlank(message = SystemMsgConstants.USER_REAL_NAME_NOT_FOUNT)
    @Schema(name = "realName", description = "真实姓名")
    private String realName;

    @NotBlank(message = SystemMsgConstants.USER_REAL_NAME_NOT_FOUNT)
    @Schema(name = "gender", description = "性别")
    private String gender;

    @Schema(name = "phoneNumber", description = "电话")
    private String phoneNumber;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;

    @Schema(name = "roleIds", description = "角色ID集合")
    private List<String> roleIds;

    @Schema(name = "positionIds", description = "职位信息")
    private List<String> positionIds;
}
