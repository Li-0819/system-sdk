package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-28 17:02
 * @description NAME
 */
@Data
@Valid
@Schema(name = "SysSignInMoodLibraryInfoClassificationListDTO", description = "签到心情图文素材库分类数据源")
public class SysSignInMoodLibraryInfoClassificationEditDTO {

    @Schema(name = "id", description = "图文素材库分类ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.CODE_NOT_FOUNT)
    @Schema(name = "code", description = "编码")
    private String code;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "名称(普通用户/推广员/商户/服务商)")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
