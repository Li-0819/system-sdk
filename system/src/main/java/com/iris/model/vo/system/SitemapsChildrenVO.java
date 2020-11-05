package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RubyWong
 * @date 2020/7/22 17:58
 * @description 扩展叶子节点
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SitemapsChildrenVO extends SitemapsBaseVO {

    @Schema(name = "icon", description = "图标")
    private String icon;

    @Schema(name = "title", description = "标题")
    private String title;
}
