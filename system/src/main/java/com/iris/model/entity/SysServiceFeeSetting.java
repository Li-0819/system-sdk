package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 服务费分润比例设置
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysServiceFeeSetting对象", description="服务费分润比例设置")
public class SysServiceFeeSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "settingType", description = "类型(服务商/平台/推广员)")
    private String settingType;

    @Schema(name = "proportion", description = "占比数(百分比)")
    private Integer proportion;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "remark", description = "备注")
    private String remark;


}
