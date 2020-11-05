package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-08-01 17:48
 * @description NAME
 */
@Data
@Schema(name = "RolesBaseVO", description = "基本角色信息")
public class RolesBaseVO {

    @Schema(name = "id", description = "ID")
    private String id;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "type", description = "类型")
    private String typeName;
}
