package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-29 16:35
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysIntegralSettingInfoListDTO", description = "获取积分配置信息列表")
public class SysIntegralSettingInfoListDTO extends PageConditionDTO {

    @Schema(name = "integralName", description = "积分名称(首次注册/每日签到/浏览职位/做任务/分享兼职/评价/推荐好友/个人实名认证/发布兼职/任务)")
    private String integralName;

    @Schema(name = "integralCode", description = "积分编码")
    private String integralCode;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
