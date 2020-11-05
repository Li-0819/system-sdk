package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysOrganizations对象", description="组织机构表")
public class SysOrganizations extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "code", description = "机构编码")
    private String code;

    @Schema(name = "parentId", description = "上级节点ID")
    private String parentId;

    @Schema(name = "parentCode", description = "上级节点编码")
    private String parentCode;

    @Schema(name = "name", description = "机构名称")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
