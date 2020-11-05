package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author RubyWong
 * @date 2020/7/22 17:23
 * @description 菜单基础信息
 */
@Data
public class SitemapsBaseVO {

    @Schema(name = "id", description = "ID")
    private String id;

    @Schema(name = "parentId", description = "父级ID")
    private String parentId;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "level", description = "等级")
    private Integer level;

    @Schema(name = "component", description = "组件名称")
    private String component;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;
}
