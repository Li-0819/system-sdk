package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 应用版本信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysAppVersion对象", description="应用版本信息")
public class SysAppVersion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "publishPlatform", description = "发布平台(小米/华为)")
    private String publishPlatform;

    @Schema(name = "appType", description = "应用类型(ios/android)")
    private String appType;

    @Schema(name = "appName", description = "应用名称")
    private String appName;

    @Schema(name = "versionNumber", description = "版本号")
    private String versionNumber;

    @Schema(name = "isNeedUpdate", description = "是否需要更新")
    private Integer isNeedUpdate;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
