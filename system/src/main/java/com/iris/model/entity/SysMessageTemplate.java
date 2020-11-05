package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 消息模版库
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysMessageTemplate对象", description="消息模板库")
public class SysMessageTemplate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "平台ID")
    private String platformId;

    @Schema(name = "分类(通知/验证码)")
    private String type;

    private String code;

    @Schema(name = "标题")
    private String title;

    @Schema(name = "内容")
    private String content;

    @Schema(name = "是否启用")
    private Integer isEnabled;

    @Schema(name = "备注")
    private String remark;


}
