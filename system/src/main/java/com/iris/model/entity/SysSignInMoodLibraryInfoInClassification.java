package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 签到心情图文素材库分类与素材库关系
 * </p>
 *
 * @author WindChaser
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSignInMoodLibraryInfoInClassification对象", description="签到心情图文素材库分类与素材库关系")
public class SysSignInMoodLibraryInfoInClassification extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "签到心情图文素材库分类")
    private String classifyId;

    @Schema(name = "签到心情图文素材库ID")
    private String moodLibraryInfoId;

    @Schema(name = "备注")
    private String remark;


}
