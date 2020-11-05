package com.iris.model.dto;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 11:36
 * @Description: ManualLoginDTO
 */
@Data
@Schema(name = "ManualLoginDTO", description = "管理平台登录参数")
public class ManualLoginDTO {

    @NotBlank(message = SystemMsgConstants.LOGIN_NAME_NOT_FOUND)
    @Schema(name = "loginName", description = "用户名", example = "admin", required = true)
    private String loginName;

    @NotBlank(message = SystemMsgConstants.PASSWORD_NOT_FOUND)
    @Schema(name = "password", description = "密码", example = "123456", required = true)
    private String password;

    @Schema(name = "employeeCode", description = "员工编码")
    private String employeeCode;

    @Schema(name = "rememberMe", description = "是否记住我(不传默认true)")
    private Boolean rememberMe;

    @Schema(name = "isPlatform", description = "是否为平台", defaultValue = "true")
    private Boolean isPlatform;

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe == null ? true : rememberMe;
    }
}
