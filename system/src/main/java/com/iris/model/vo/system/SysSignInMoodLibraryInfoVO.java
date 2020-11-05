package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-28 13:35
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodLibraryInfoVO", description = "签到心情图文素材库结果实体")
public class SysSignInMoodLibraryInfoVO extends BaseVO {

    @Schema(name = "libraryName", description = "素材名称")
    private String libraryName;

    @Schema(name = "libraryImg", description = "图片")
    private String libraryImg;

    @Schema(name = "libraryContent", description = "内容")
    private String libraryContent;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "sysSignInMoodLibraryInfoClassificationVOS", description = "素材库分类")
    private List<SysSignInMoodLibraryInfoClassificationVO> sysSignInMoodLibraryInfoClassificationVOS;
}
