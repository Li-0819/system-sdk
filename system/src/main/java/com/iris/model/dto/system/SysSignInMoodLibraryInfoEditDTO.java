package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-28 14:57
 * @description SysSignInMoodLibraryInfoEditDTO
 */
@Data
@Valid
@Schema(name = "SysSignInMoodLibraryInfoListDTO", description = "签到心情图文素材库数据源")
public class SysSignInMoodLibraryInfoEditDTO {

    @Schema(name = "id", description = "图文素材库ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.LIBRARY_NAME_NOT_FOUND)
    @Schema(name = "libraryName", description = "素材名称")
    private String libraryName;

    @Schema(name = "classifyIds", description = "签到心情图文素材库分类IDS")
    private List<String> classifyIds;

    @Schema(name = "libraryImg", description = "图片")
    private String libraryImg;

    @Schema(name = "libraryContent", description = "内容")
    private String libraryContent;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
