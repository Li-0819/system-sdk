package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author WindChaser
 * @createTime 2020-07-29 14:15
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysMemberPrivilegeCardSettingEditDTO", description = "会员特权卡设置数据源")
public class SysMemberPrivilegeCardSettingEditDTO {

    @Schema(name = "会员特权卡ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.MEMBER_PRIVILEGE_CARD_TYPE_NOT_FOUND)
    @Schema(name = "type", description = "卡片分类(抢位卡/禁闭卡)")
    private String type;

    @DecimalMin(value = "0", message = SystemMsgConstants.MEMBER_PRIVILEGE_CARD_CASH_PRICE_NOT_LESS_ZERO)
    @Schema(name = "cashPrice", description = "现金单价(单位为分)")
    private BigDecimal cashPrice;

    @DecimalMin(value = "0", message = SystemMsgConstants.MEMBER_PRIVILEGE_CARD_INTEGRAL_PRICE_NOT_LESS_ZERO)
    @Schema(name = "integralPrice", description = "积分单价")
    private Integer integralPrice;

    @Schema(name = "icon", description = "图标")
    private String icon;

    @Schema(name = "backImg", description = "卡片背景图片")
    private String backImg;

    @Schema(name = "isEnabled", description = "是否可用")
    private Integer isEnabled;

    @Schema(name = "remark", description = "备注")
    private String remark;

    public void setCashPrice(BigDecimal cashPrice) {

        this.cashPrice = cashPrice.multiply(BigDecimal.valueOf(100L));
    }
}