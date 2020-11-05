package com.iris.model.dto.system;


import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-31 10:20
 * @description NAME
 */
@Data
@Schema(name = "SysRolesEditDTO", description = "角色管理数据源")
public class SysRolesEditDTO {

    @Schema(name = "id", description = "角色ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "organizationId", description = "机构ID")
    private String organizationId;

    @NotBlank(message = SystemMsgConstants.CODE_NOT_FOUNT)
    @Schema(name = "code", description = "编码")
    private String code;

    @NotBlank(message = SystemMsgConstants.TYPE_NOT_FOUNT)
    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;
}
