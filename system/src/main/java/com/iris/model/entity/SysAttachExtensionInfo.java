package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 附件扩展限定信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysAttachExtensionInfo对象", description="附件扩展限定信息")
public class SysAttachExtensionInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "名称(doc/docx等)")
    private String name;

    @Schema(name = "扩展名")
    private String extension;

    @Schema(name = "备注")
    private String remark;
}
