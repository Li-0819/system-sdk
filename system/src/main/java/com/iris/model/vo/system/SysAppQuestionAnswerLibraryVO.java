package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-30 10:04
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysAppQuestionAnswerLibraryVO", description = "APP答疑资料库结果实体")
public class SysAppQuestionAnswerLibraryVO extends BaseVO {

    @Schema(name = "type", description = "分类")
    private String type;

    @Schema(name = "typeName", description = "分类名称")
    private String typeName;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "url", description = "链接")
    private String url;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "attachInfoVOS", description = "附件信息")
    private List<SysAttachInfoVO> attachInfoVOS;
}
