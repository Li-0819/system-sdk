package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 签到心情配置信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSignInMoodSetting对象", description="签到心情配置信息")
public class SysSignInMoodSetting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "moodName", description = "心情名称(得意/狂喜/微笑/忧愁/郁闷)")
    private String moodName;

    @Schema(name = "moodCode", description = "心情编码")
    private String moodCode;

    @Schema(name = "themeImg", description = "主题图片")
    private String themeImg;

    @Schema(name = "themeColor", description = "主题色")
    private String themeColor;

    @Schema(name = "themePageDemo", description = "分享页面示例")
    private String themePageDemo;

    @Schema(name = "remark", description = "备注")
    private String remark;


}
