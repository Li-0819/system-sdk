package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户与组织机构表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUserInOrganization对象", description="用户与组织机构表")
public class SysUserInOrganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String organizationId;

    private String userId;


}
