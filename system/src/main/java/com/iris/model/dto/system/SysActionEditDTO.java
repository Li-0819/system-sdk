package com.iris.model.dto.system;


import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-23 21:06
 * @description SysActionEditDTO
 */
@Data
@Valid
@Schema(name = "SysActionEditDTO", description = "功能管理编辑数据源")
public class SysActionEditDTO {

    @Schema(name = "id", description = "数据字典信息ID")
    private String id;

    @Schema(name = "sitemapId", description = "菜单id")
    private String sitemapId;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "名称")
    private String name;

    @NotBlank(message = SystemMsgConstants.TITLE_NOT_FOUNT)
    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "description", description = "描述")
    private String description;

    @NotBlank(message = SystemMsgConstants.ACTION_KEY_NOT_FOUND)
    @Schema(name = "key", description = "键值")
    private String key;

    @NotBlank(message = SystemMsgConstants.ACTION_AREA_NOT_FOUND)
    @Schema(name = "area", description = "区域")
    private String area;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;
}
