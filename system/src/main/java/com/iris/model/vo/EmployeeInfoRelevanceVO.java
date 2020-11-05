package com.iris.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-08-14 09:16
 * @description NAME
 */
@Data
@Schema(name = "EmployeeInfoRelevanceVO", description = "关联vo")
public class EmployeeInfoRelevanceVO {

    @Schema(name = "id", description = "员工ID")
    private String id;

    @Schema(name = "orderId", description = "订单ID")
    private String orderId;

    @Schema(name = "employeeCode", description = "员工编号")
    private String employeeCode;

    @Schema(name = "employeeName", description = "员工名称")
    private String employeeName;

    @Schema(name = "employeeClass", description = "员工类型(营养师)")
    private String employeeClass;

    @Schema(name = "employeeClassName", description = "员工类型(营养师)")
    private String employeeClassName;

    @Schema(name = "gender", description = "性别")
    private String gender;

    private String genderName;

    @Schema(name = "mobileNumber", description = "手机号码")
    private String mobileNumber;

    @Schema(name = "employeeStatus", description = "员工状态")
    private String employeeStatus;

    @Schema(name = "employeeStatusName", description = "员工状态名称")
    private String employeeStatusName;

    @Schema(name = "isAuth", description = "是否认证")
    private Integer isAuth;

//    @Schema(name = "memberInfoRelevanceVOS", description = "关联会员信息关联数据")
//    private List<MemberInfoRelevanceVO> memberInfoRelevanceVOS;
//
//    @Schema(name = "organizationInfoRelevanceVOS", description = "关联机构信息数据")
//    private List<OrganizationInfoRelevanceVO> organizationInfoRelevanceVOS;
}
