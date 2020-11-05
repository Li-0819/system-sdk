package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-01 15:04
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "UserListDTO", description = "查询用户列表")
public class UserListDTO extends PageConditionDTO {

    @Schema(name = "organizationId", description = "组织机构ID")
    private String organizationId;

    @Schema(name = "isPlatform", description = "是否是平台")
    private Integer isPlatform;

    @Schema(name = "loginName", description = "登陆名")
    private String loginName;

    @Schema(name = "realName", description = "真实姓名")
    private String realName;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}