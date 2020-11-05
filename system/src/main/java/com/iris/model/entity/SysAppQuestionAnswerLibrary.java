package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * APP答疑资料库
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysAppQuestionAnswerLibrary对象", description="APP答疑资料库")
public class SysAppQuestionAnswerLibrary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "type", description = "分类")
    private String type;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "url", description = "链接")
    private String url;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
