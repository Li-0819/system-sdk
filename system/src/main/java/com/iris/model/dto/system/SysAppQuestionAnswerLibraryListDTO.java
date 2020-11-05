package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-30 09:49
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysAppQuestionAnswerLibraryListDTO", description = "APP答疑资料库列表")
public class SysAppQuestionAnswerLibraryListDTO extends PageConditionDTO {

    @Schema(name = "type", description = "分类")
    private String type;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
