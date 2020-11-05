package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-28 16:38
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodLibraryInfoClassificationListDTO", description = "签到心情图文素材库分类列表查询")
public class SysSignInMoodLibraryInfoClassificationListDTO extends PageConditionDTO {

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "name", description = "名称(普通用户/推广员/商户/服务商)")
    private String name;
}
