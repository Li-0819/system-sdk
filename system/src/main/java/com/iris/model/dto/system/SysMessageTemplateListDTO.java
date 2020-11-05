package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-24 23:20
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysMessageTemplateListDTO", description = "消息模版列表查询")
public class SysMessageTemplateListDTO extends PageConditionDTO {

    @Schema(name = "platformId", description = "平台ID")
    private Integer platformId;

    @Schema(name = "type", description = "分类(通知/验证码)")
    private String type;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "isEnabled", description = "是否启用")
    private Integer isEnabled;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
