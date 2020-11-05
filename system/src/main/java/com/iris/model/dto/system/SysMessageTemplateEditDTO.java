package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author WindChaser
 * @create 2020-07-20
 * @desc SysMessageTemplateDTO
 **/
@Data
@Valid
@Schema(name = "SysMessageTemplateEditDTO", description = "消息模版编辑数据源")
public class SysMessageTemplateEditDTO {

    @Schema(name = "id", description = "消息模版库ID")
    private String id;

    @NotNull(message = SystemMsgConstants.SMS_PLATFORM_ID_NOT_FOUND)
    @Schema(name = "platformId", description = "平台ID")
    private Integer platformId;

    @NotBlank(message = SystemMsgConstants.TYPE_NOT_FOUNT)
    @Schema(name = "type", description = "分类(通知/验证码)")
    private String type;

    @NotBlank(message = SystemMsgConstants.CODE_NOT_FOUNT)
    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "isEnabled", description = "是否启用")
    private Integer isEnabled;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
