package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-01 17:45
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "UsersDetailVO", description = "用户详情信息")
public class UsersDetailVO extends BaseVO {

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

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;

    @Schema(name = "rolesBaseVOS", description = "基础角色信息列表")
    private List<RolesBaseVO> rolesBaseVOS;

    @Schema(name = "positionBaseVOS", description = "基础职位信息列表")
    private List<PositionBaseVO> positionBaseVOS;
}
