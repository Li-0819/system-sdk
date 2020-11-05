package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-24 23:30
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysBannerListDTO", description = "banner信息列表查询")
public class SysBannerListDTO extends PageConditionDTO {

    @Schema(name = "bannerType", description = "banner类型(外部链接/内部链接/无连接)")
    private String bannerType;

    @Schema(name = "bannerName", description = "banner名称")
    private String bannerName;

    @Schema(name = "isEnabled", description = "是否可用")
    private Integer isEnabled;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
