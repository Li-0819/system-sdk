package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RubyWong
 * @date 2020/2/6 10:20
 * @description 数据字典列表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysCodeListDTO", description = "分页查询数据字典列表")
public class SysCodeListDTO extends PageConditionDTO {

    @Schema(name = "name", description = "数据字典名称")
    private String name;

    @Schema(name = "type", description = "数据字典类型")
    private String type;

    @Schema(name = "name", description = "数据字典值")
    private String value;
}
