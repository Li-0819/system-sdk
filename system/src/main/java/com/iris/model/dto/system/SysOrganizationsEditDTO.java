package com.iris.model.dto.system;

import com.iris.model.dto.organization.OrganizationExtraInfoEditDTO;
import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-31 13:59
 * @description NAME
 */
@Data
@Schema(name = "SysOrganizationsEditDTO", description = "组织机构数据源")
public class SysOrganizationsEditDTO {

    @Schema(name = "id", description = "组织机构ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.CODE_NOT_FOUNT)
    @Schema(name = "code", description = "机构编码")
    private String code;

    @Schema(name = "parentId", description = "上级节点ID")
    private String parentId;

    @Schema(name = "organizationExtraInfoEditDTO", description = "机构附属信息")
    private OrganizationExtraInfoEditDTO organizationExtraInfoEditDTO;

    @Schema(name = "userEditDTO", description = "用户信息")
    private UserEditDTO userEditDTO;

    @NotBlank(message = SystemMsgConstants.NAME_NOT_FOUNT)
    @Schema(name = "name", description = "机构名称")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;

    @Schema(name = "addAdmin", description = "是否添加内置用戶")
    private boolean addAdmin;
}
