package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色与机构关系表
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="RoleInOrganization对象", description="角色与机构关系表")
public class RoleInOrganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "organizationId", description = "机构ID")
    private String organizationId;

    @Schema(name = "roleId", description = "角色ID")
    private String roleId;

    @Schema(name = "remark", description = "备注")
    private String remark;


}
