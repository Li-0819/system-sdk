package com.iris.model.vo.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iris.config.JacksonHttpMessageConverter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-09-03 22:38
 * @description NAME
 */
@Data
public class SysAttachInfoVO {

    @Schema(name = "ID")
    private String id;

    @Schema(name = "关联表ID")
    private String refId;

    @Schema(name = "类型")
    private String attachType;

    @Schema(name = "类型名称")
    private String attachTypeName;

    @Schema(name = "名称")
    private String attachName;

    @JsonSerialize(using = JacksonHttpMessageConverter.PathPrefixJsonSerializer.class)
    @Schema(name = "文件地址")
    private String path;

    @Schema(name = "转码地址")
    private String transformPath;

    @Schema(name = "扩展名")
    private String extension;

    @Schema(name = "文件附加信息")
    private String extraInfo;

    @Schema(name = "排序")
    private Integer sequence;
}
