package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author WindChaser
 * @createTime 2020-07-29 13:42
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysMemberPrivilegeCardSettingVO", description = "会员特权卡设置结果实体")
public class SysMemberPrivilegeCardSettingVO extends BaseVO {

    @Schema(name = "type", description = "卡片分类(抢位卡/禁闭卡)")
    private String type;

    @Schema(name = "typeName", description = "卡片分类名称")
    private String typeName;

    @Schema(name = "cashPrice", description = "现金单价(单位为分)")
    private BigDecimal cashPrice;

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

        this.cashPrice = cashPrice.divide(BigDecimal.valueOf(100L));
    }
}
