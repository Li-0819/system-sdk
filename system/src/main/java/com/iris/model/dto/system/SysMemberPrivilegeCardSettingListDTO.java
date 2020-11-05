package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-29 13:25
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysMemberPrivilegeCardSettingListDTO", description = "会员特权卡设置列表查询")
public class SysMemberPrivilegeCardSettingListDTO extends PageConditionDTO {

    @Schema(name = "type", description = "卡片分类(抢位卡/禁闭卡)")
    private String type;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;

}
