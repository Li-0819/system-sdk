package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-27 10:37
 * @description SysAppVersionListDTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysAppVersionListDTO", description = "应用版本信息列表查询")
public class SysAppVersionListDTO extends PageConditionDTO {

    @Schema(name = "appType", description = "应用类型(ios/android)")
    private String appType;

    @Schema(name = "appName", description = "应用名称")
    private String appName;

    @Schema(name = "appCode", description = "应用编码")
    private String appCode;

    @Schema(name = "versionNumber", description = "版本号")
    private String versionNumber;

    @Schema(name = "publishPlatform", description = "发布平台(小米/华为)")
    private String publishPlatform;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
