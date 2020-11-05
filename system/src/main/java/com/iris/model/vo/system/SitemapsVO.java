package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author RubyWong
 * @date 2020/7/22 17:19
 * @description 菜单列表
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SitemapsVO extends SitemapsBaseVO {

    @Schema(name = "icon", description = "图标")
    private String icon;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "children", description = "菜单叶子节点")
    private List<SitemapsChildrenVO> children;
}
