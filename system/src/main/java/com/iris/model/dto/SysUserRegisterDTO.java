package com.iris.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 13:55
 * @Description: SysUserRegisterDTO
 */
@Data
public class SysUserRegisterDTO {

    private static final long serialVersionUID = 1L;

    @Schema(name = "登陆名")
    private String loginName;

    @Schema(name = "密码")
    private String loginPwd;

    @Schema(name = "真实姓名")
    private String realName;

    @Schema(name = "性别")
    private String gender;

    @Schema(name = "电话")
    private String phoneNumber;

    @Schema(name = "职位描述")
    private String userPosition;

    @Schema(name = "备注")
    private String remark;
}
