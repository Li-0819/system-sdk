package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author WindChaser
 * @createTime 2020-08-03 10:03
 * @description NAME
 */
@Data
@Schema(name = "SysUserBaseDTO")
public class SysUserResetDTO {

    @Schema(name = "id", description = "用户ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.USER_LOGIN_NAME_NOT_FOUNT)
    @Schema(name = "loginName", description = "登陆名")
    private String loginName;

    @Size(min = 6, max = 16, message = SystemMsgConstants.PASSWORD_LENGTH_ERROR)
    @Schema(name = "passWord", description = "密码")
    private String passWord;

    @Schema(name = "resetOrUpdate", description = "重置(0)  修改(1)", example = "0")
    private Integer resetOrUpdate;
}
