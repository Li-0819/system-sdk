package com.iris.model.dto.system;


import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author RubyWong
 * @date 2020/2/6 10:20
 * @description 数据字典列表
 */
@Data
@Valid
@Schema(name = "SysCodeEditDTO", description = "数据字典详情编辑数据源")
public class SysCodeEditDTO {

    @Schema(name = "id", description = "数据字典信息ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.CODE_NOT_FOUNT)
    @Schema(name = "code", description = "编码", required = true)
    private String code;

    @NotBlank(message = SystemMsgConstants.VALUE_NOT_FOUNT)
    @Schema(name = "value", description = "值", required = true)
    private String value;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "名称", required = true)
    private String name;

    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence = 0;
}
