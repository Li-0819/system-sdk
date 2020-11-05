package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * banner信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysBanner对象", description="banner信息")
public class SysBanner extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "bannerType", description = "banner类型(外部链接/内部链接/无连接)")
    private String bannerType;

    @Schema(name = "bannerName", description = "banner名称")
    private String bannerName;

    @Schema(name = "imgUrl", description = "图片地址")
    private String imgUrl;

    @Schema(name = "linkUrl", description = "链接地址")
    private String linkUrl;

    @Schema(name = "isEnabled", description = "是否可用")
    private Integer isEnabled;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
