package com.iris.model.vo.system;


import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-31 09:37
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysRolesVO", description = "角色结果实体")
public class SysRolesVO extends BaseVO {

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "typeName", description = "类型名称")
    private String typeName;

//    @Schema(name = "organizationId", description = "机构ID")
//    private String organizationId;
//
//    @Schema(name = "organizationName", description = "机构名称")
//    private String organizationName;
//
//    @Schema(name = "isPlatform", description = "是否是平台")
//    private Integer isPlatform;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;
}
