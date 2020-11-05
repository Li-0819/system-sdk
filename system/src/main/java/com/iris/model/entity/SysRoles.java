package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysRoles对象", description="角色管理")
public class SysRoles extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;
}
