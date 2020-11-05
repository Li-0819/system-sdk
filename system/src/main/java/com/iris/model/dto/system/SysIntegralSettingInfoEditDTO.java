package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-29 16:50
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysIntegralSettingInfoEditDTO", description = "积分配置数据源")
public class SysIntegralSettingInfoEditDTO {

    @Schema(name = "id", description = "积分配置ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.INTEGRAL_NAME_NOT_FOUND)
    @Schema(name = "integralName", description = "积分名称(首次注册/每日签到/浏览职位/做任务/分享兼职/评价/推荐好友/个人实名认证/发布兼职/任务)")
    private String integralName;

    @NotBlank(message = SystemMsgConstants.INTEGRAL_CODE_NOT_FOUND)
    @Schema(name = "integralCode", description = "积分编码")
    private String integralCode;

    @Schema(name = "integralScore", description = "积分数")
    private Integer integralScore;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
