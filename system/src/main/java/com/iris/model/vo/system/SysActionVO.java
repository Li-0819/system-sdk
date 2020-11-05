package com.iris.model.vo.system;


import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RubyWong
 * @date 2020/7/23 10:03
 * @description 按钮功能
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysActionVO extends BaseVO {

    @Schema(name = "sitemapId", description = "菜单ID")
    private String sitemapId;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "key", description = "键值")
    private String key;

    @Schema(name = "area", description = "区域")
    private String area;

    @Schema(name = "description", description = "描述")
    private String description;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;
}
