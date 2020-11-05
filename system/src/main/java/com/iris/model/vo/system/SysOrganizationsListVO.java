package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-31 13:31
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysOrganizationsVO", description = "组织机构表")
public class SysOrganizationsListVO extends SysOrganizationsMapBaseVO {

    @Schema(name = "parentId", description = "上级节点ID")
    private String parentId;

    @Schema(name = "parentCode", description = "上级节点编码")
    private String parentCode;

    @Schema(name = "children", description = "组织机构叶子节点")
    private List<Children> children;
}
