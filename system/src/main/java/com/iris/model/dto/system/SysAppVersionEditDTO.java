package com.iris.model.dto.system;


import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-27 13:38
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysAppVersionListDTO", description = "应用版本信息列表查询")
public class SysAppVersionEditDTO {

    @Schema(name = "id", description = "应用版本信息ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.APP_TYPE_NOT_FOUND)
    @Schema(name = "appType", description = "应用类型(ios/android)")
    private String appType;

    @NotBlank(message = SystemMsgConstants.APP_NAME_NOT_FOUND)
    @Schema(name = "appName", description = "应用名称")
    private String appName;

    @Schema(name = "versionNumber", description = "版本号")
    private String versionNumber;

    @Schema(name = "isNeedUpdate", description = "是否需要更新")
    private Integer isNeedUpdate;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @NotBlank(message = SystemMsgConstants.APP_PUBLISH_PLATFORM_NOT_FOUND)
    @Schema(name = "publishPlatform", description = "发布平台(小米/华为)")
    private String publishPlatform;
}
