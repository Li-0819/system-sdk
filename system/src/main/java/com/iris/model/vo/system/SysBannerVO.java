package com.iris.model.vo.system;


import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-23 16:50
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysBannerVO", description = "banner信息返回实体")
public class SysBannerVO extends BaseVO {

    @Schema(name = "bannerType", description = "banner类型(外部链接/内部链接/无连接)")
    private String bannerType;

    @Schema(name = "codeName", description = "banner名称")
    private String codeName;

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

    @Schema(name = "sysAttachInfo", description = "附件信息")
    private List<SysAttachInfoVO> attachInfoVOS;
}
