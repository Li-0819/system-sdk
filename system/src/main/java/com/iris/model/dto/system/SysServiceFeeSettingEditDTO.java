package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-30 15:10
 * @description SysServiceFeeSettingEditDTO
 */
@Data
@Valid
@Schema(name = "SysServiceFeeSettingEditDTO", description = "服务费分润比例设置数据源")
public class SysServiceFeeSettingEditDTO {

    @Schema(name = "id", description = "服务费分润比例ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.TYPE_NOT_FOUNT)
    @Schema(name = "settingType", description = "类型(服务商/平台/推广员)")
    private String settingType;

    @DecimalMin(value = "0", message = SystemMsgConstants.SERVICE_FEE_PROPORTION_NOT_LESS_ZERO)
    @Schema(name = "proportion", description = "占比数(百分比)")
    private Integer proportion;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
