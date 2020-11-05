package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author RubyWong
 * @date 2020/7/22 16:50
 * @description 菜单扩展属性
 */
@Data
public class SitemapsMetaVO {

    @Schema(name = "icon", description = "图标")
    private String icon;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "show", description = "是否显示")
    private Integer show = 1;
}
