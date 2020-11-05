package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-29 16:39
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysIntegralSettingInfoVO", description = "积分配置信息结果实体")
public class SysIntegralSettingInfoVO extends BaseVO {

    @Schema(name = "integralName", description = "积分名称(首次注册/每日签到/浏览职位/做任务/分享兼职/评价/推荐好友/个人实名认证/发布兼职/任务)")
    private String integralName;

    @Schema(name = "integralCode", description = "积分编码")
    private String integralCode;

    @Schema(name = "integralScore", description = "积分数")
    private Integer integralScore;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
