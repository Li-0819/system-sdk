package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 会员与员工与用户与组织机构关系表
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="MemberInEmployeeInUserInOrganization对象", description="会员与员工与用户与组织机构关系表")
public class MemberInEmployeeInUserInOrganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "机构ID")
    private String organizationId;

    @Schema(description = "员工ID")
    private String employeeId;

    @Schema(description = "会员ID")
    private String memberId;

    @Schema(description = "用户ID")
    private String userId;

    @Schema(description = "备注")
    private String remark;


}
