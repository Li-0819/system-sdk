package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-31 09:34
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysRolesListDTO", description = "获取角色管理列表")
public class SysRolesListDTO extends PageConditionDTO {

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "organizationId", description = "机构ID")
    private String organizationId;

    @Schema(name = "isPlatform", description = "是否是平台")
    private String isPlatform;

    @Schema(name = "type", description = "类型")
    private String type;
}
