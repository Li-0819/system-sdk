package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-27 16:45
 * @description SysSignInMoodSettingListDTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodSettingListDTO", description = "签到心情配置信息列表查询")
public class SysSignInMoodSettingListDTO extends PageConditionDTO {

    @Schema(name = "moodName", description = "心情名称(得意/狂喜/微笑/忧愁/郁闷)")
    private String moodName;

    @Schema(name = "moodCode", description = "心情编码")
    private String moodCode;

    @Schema(name = "themeColor", description = "主题色")
    private String themeColor;
}
