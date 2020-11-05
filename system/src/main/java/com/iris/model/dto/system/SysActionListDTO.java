package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RubyWong
 * @date 2020/7/23 11:23
 * @description 按钮功能
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysActionListDTO", description = "分页查询数据字典列表")
public class SysActionListDTO extends PageConditionDTO {

    @Schema(name = "sitemapId", description = "菜单ID")
    private String sitemapId;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
