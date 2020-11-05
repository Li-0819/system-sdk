package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 签到心情图文素材库分类
 * </p>
 *
 * @author WindChaser
 * @since 2020-07-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSignInMoodLibraryInfoClassification对象", description="签到心情图文素材库分类")
public class SysSignInMoodLibraryInfoClassification extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "name", description = "名称(普通用户/推广员/商户/服务商)")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
