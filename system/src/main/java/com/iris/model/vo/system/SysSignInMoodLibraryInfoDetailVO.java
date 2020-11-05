package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-05 15:03
 * @description: 签到心情图文素材库详情
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodLibraryInfoDetailVO", description = "签到心情图文素材库详情")
public class SysSignInMoodLibraryInfoDetailVO extends SysSignInMoodLibraryInfoListVO{

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "sysSignInMoodLibraryInfoClassificationVOS", description = "素材库分类")
    private List<SysSignInMoodLibraryInfoClassificationVO> classificationVOList;
}
