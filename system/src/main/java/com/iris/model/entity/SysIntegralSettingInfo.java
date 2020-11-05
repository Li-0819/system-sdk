package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分配置信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysIntegralSettingInfo对象", description="积分配置信息")
public class SysIntegralSettingInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
