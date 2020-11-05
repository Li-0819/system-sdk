package com.iris.model.dto.system;


import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-30 09:55
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysAppQuestionAnswerLibraryEditDTO", description = "APP答疑资料库数据源")
public class SysAppQuestionAnswerLibraryEditDTO {

    @Schema(name = "id", description = "APP答疑资料库ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.TYPE_NOT_FOUNT)
    @Schema(name = "type", description = "分类")
    private String type;

    @NotBlank(message = SystemMsgConstants.TITLE_NOT_FOUNT)
    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "url", description = "链接")
    private String url;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "remark", description = "备注")
    private String remark;

    //    @Size(max = 3, message = SystemMsgConstants.UP_TO_UPLOAD_THREE_ACCESSORIES)
    @Schema(name = "attachIds", description = "附件id集合")
    private List<String> attachIds;
}
