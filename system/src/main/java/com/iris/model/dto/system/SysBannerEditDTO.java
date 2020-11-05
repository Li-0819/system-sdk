package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-23 16:26
 * @description SysBannerDTO
 */
@Data
@Valid
@Schema(name = "SysBannerEditDTO", description = "banner信息编辑数据源")
public class SysBannerEditDTO {

    @Schema(name = "id", description = "banner信息ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.BANNER_NAME_NOT_FOUNT)
    @Schema(name = "bannerType", description = "banner类型(外部链接/内部链接/无连接)")
    private String bannerType;

    @NotBlank(message = SystemMsgConstants.BANNER_TYPE_NOT_FOUNT)
    @Schema(name = "bannerName", description = "banner名称")
    private String bannerName;

    @Schema(name = "imgUrl", description = "图片地址")
    private String imgUrl;

    @Schema(name = "attachIds", description = "附件关联ID")
    private List<String> attachIds;

    @Schema(name = "linkUrl", description = "链接地址")
    private String linkUrl;

    @Schema(name = "是否可用", description = "是否可用")
    private Integer isEnabled;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
