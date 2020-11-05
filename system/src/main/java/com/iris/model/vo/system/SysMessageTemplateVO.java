package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-20
 * @description SysBannerDTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysMessageTemplateVO", description = "消息模版库结果实体")
public class SysMessageTemplateVO extends BaseVO {

    @Schema(name = "platformId", description = "平台ID")
    private Integer platformId;

    @Schema(name = "type", description = "分类(通知/验证码)")
    private String type;

    @Schema(name = "typeName", description = "分类名称")
    private String typeName;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "isEnabled", description = "是否启用")
    private Integer isEnabled;

    @Schema(name = "remark", description = "备注")
    private String remark;



}
