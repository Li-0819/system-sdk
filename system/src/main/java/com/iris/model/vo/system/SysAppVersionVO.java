package com.iris.model.vo.system;


import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-27 10:44
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysAppVersionVO", description = "应用版本信息结果实体")
public class SysAppVersionVO extends BaseVO {

    @Schema(name = "appType", description = "应用类型(ios/android)")
    private String appType;

    @Schema(name = "appTypeName", description = "应用类型名称")
    private String appTypeName;

    @Schema(name = "appName", description = "appName")
    private String appName;

    @Schema(name = "versionNumber", description = "版本号")
    private String versionNumber;

    @Schema(name = "isNeedUpdate", description = "是否需要更新")
    private Integer isNeedUpdate;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "publishPlatform", description = "发布平台(小米/华为)")
    private String publishPlatform;

    @Schema(name = "publishPlatformName", description = "发布平台名称")
    private String publishPlatformName;
}
