package com.iris.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 功能管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysAction对象", description="功能管理")
public class SysAction extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "菜单id")
    private String sitemapId;

    @Schema(name = "名称")
    private String name;

    @Schema(name = "标题")
    private String title;

    @Schema(name = "描述")
    private String description;

    @Schema(name = "键值")
    @TableField("`key`")
    private String key;

    @Schema(name = "区域")
    private String area;

    @Schema(name = "排序")
    private Integer sequence;
}
