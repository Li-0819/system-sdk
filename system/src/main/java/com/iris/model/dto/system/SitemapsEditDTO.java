package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-08-22 10:18
 * @description NAME
 */
@Data
@Schema(name = "SitemapsEditDTO", description = "菜单管理编辑")
public class SitemapsEditDTO {

    @Schema(name = "id", description = "ID")
    private String id;

    @Schema(name = "parentId", description = "父级ID")
    private String parentId;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "level", description = "等级")
    private Integer level;

    @Schema(name = "icon", description = "图标")
    private String icon;

    @Schema(name = "是否是平台")
    private Integer isPlatform;

    @NotBlank(message = SystemMsgConstants.COMPONENT_NOT_NULL)
    @Schema(name = "component", description = "组件名称")
    private String component;

    @NotBlank(message = SystemMsgConstants.TITLE_NOT_FOUNT)
    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;
}
