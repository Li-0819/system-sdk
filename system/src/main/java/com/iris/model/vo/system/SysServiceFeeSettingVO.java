package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-30 14:14
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysServiceFeeSettingVO", description = "服务费分润比例设置结果数据源")
public class SysServiceFeeSettingVO extends BaseVO {

    @Schema(name = "settingType", description = "类型(服务商/平台/推广员)")
    private String settingType;

    @Schema(name = "settingTypeName", description = "类型名称")
    private String settingTypeName;

    @Schema(name = "proportion", description = "占比数(百分比)")
    private Integer proportion;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
