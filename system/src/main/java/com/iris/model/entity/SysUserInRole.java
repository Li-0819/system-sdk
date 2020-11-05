package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUserInRole对象", description="用户角色关系表")
public class SysUserInRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private String userId;
}
