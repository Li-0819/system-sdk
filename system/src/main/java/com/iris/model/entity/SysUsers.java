package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUsers对象", description="用户管理")
public class SysUsers extends BaseEntity {

    private static final long serialVersionUID = 1L;

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

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
