package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 附件信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysAttachInfo对象", description="附件信息")
public class SysAttachInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "关联表ID")
    private String refId;

    @Schema(name = "类型")
    private String attachType;

    @Schema(name = "名称")
    private String attachName;

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
