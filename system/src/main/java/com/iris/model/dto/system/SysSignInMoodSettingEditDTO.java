package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-27 17:33
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysSignInMoodSettingEditDTO", description = "签到心情配置信息数据源")
public class SysSignInMoodSettingEditDTO {

    @Schema(name = "id", description = "签到心情配置信息ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.SIGN_IN_MOOD_NAME_NOT_FOUND)
    @Schema(name = "moodName", description = "心情名称(得意/狂喜/微笑/忧愁/郁闷)")
    private String moodName;

    @NotBlank(message = SystemMsgConstants.SIGN_IN_MOOD_CODE_NOT_FOUND)
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
