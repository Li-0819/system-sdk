package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-09-04 20:48
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "MessageInfoListDTO", description = "获取系统消息")
public class CommonMessageInfoListDTO extends PageConditionDTO {

    @Schema(name = "receiverId", description = "消息接受者ID")
    private String receiverId;

    @Schema(name = "businessType", description = "消息接受类型(会员/员工)")
    private String businessType;

}
