package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-01 14:48
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "UsersListVO", description = "列表用户信息")
public class UsersListVO extends BaseVO {

    @Schema(name = "loginName", description = "登陆名")
    private String loginName;

    @Schema(name = "realName", description = "真实姓名")
    private String realName;

    @Schema(name = "gender", description = "性别")
    private String gender;

    @Schema(name = "genderName", description = "性别名称")
    private String genderName;

    @Schema(name = "phoneNumber", description = "电话")
    private String phoneNumber;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否已锁定")
    private Integer isLocked;

    @Schema(name = "roleNameJoin", description = "角色名拼接")
    private String roleNameJoin;
}
