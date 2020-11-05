package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 会员特权卡设置
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysMemberPrivilegeCardSetting对象", description="会员特权卡设置")
public class SysMemberPrivilegeCardSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "卡片分类(抢位卡/禁闭卡)")
    private String type;

    @Schema(name = "现金单价(单位为分)")
    private BigDecimal cashPrice;

    @Schema(name = "积分单价")
    private Integer integralPrice;

    @Schema(name = "icon")
    private String icon;

    @Schema(name = "卡片背景图片")
    private String backImg;

    @Schema(name = "是否可用")
    private Integer isEnabled;

    @Schema(name = "备注")
    private String remark;


}
