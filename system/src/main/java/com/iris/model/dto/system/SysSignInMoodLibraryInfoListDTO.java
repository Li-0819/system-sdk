package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-28 13:32
 * @description SysSignInMoodLibraryInfoListDTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodLibraryInfoListDTO", description = "获取签到心情图文素材库列表")
public class SysSignInMoodLibraryInfoListDTO extends PageConditionDTO {

    @Schema(name = "libraryName", description = "素材名称")
    private String libraryName;

    @Schema(name = "classifyId", description = "分类")
    private String classifyId;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
