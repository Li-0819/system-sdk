package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSitemaps对象", description="菜单管理")
public class SysSitemaps extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "父级id")
    private String parentId;

    @Schema(name = "名称")
    private String name;

    @Schema(name = "标题")
    private String title;

    @Schema(name = "等级")
    private Integer level;

    @Schema(name = "图标")
    private String icon;

    @Schema(name = "组件名称")
    private String component;

    @Schema(name = "是否是平台")
    private Integer isPlatform;

    private String url;

    @Schema(name = "排序")
    private Integer sequence;
}
