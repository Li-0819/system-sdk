package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-27 16:48
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodSettingVO", description = "签到心情配置信息结果实体")
public class SysSignInMoodSettingVO extends BaseVO {


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
