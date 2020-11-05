package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: izanagi
 * @Date: 2020-07-20 11:56
 * @Description: UsersInfoVO
 */
@Data
@Schema(name = "UsersInfoVO", description = "用户信息")
public class UsersInfoVO {

    @Schema(name = "loginName", description = "登陆名")
    private String loginName;

    @Schema(name = "loginPwd", description = "密码")
    private String loginPwd;

    @Schema(name = "realName", description = "真实姓名")
    private String realName;

    @Schema(name = "gender", description = "性别")
    private String gender;

    @Schema(name = "phoneNumber", description = "电话")
    private String phoneNumber;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否已锁定")
    private Integer isLocked;
}
