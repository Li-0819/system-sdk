package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author WindChaser
 * @createTime 2020-07-31 16:58
 * @description NAME
 */
@Data
@Schema(name = "SysPositionListDTO", description = "职位信息列表实体")
public class SysPositionEditDTO {

    @Schema(name = "id", description = "职位信息ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.ORGANIZATIONS_ID_NOT_FOUNT)
    @Schema(name = "organizationsId", description = "机构编码")
    private String organizationsId;

    @NotBlank(message = SystemMsgConstants.POSITION_NAME_NOT_FOUNT)
    @Schema(name = "positionName", description = "机构名称")
    private String positionName;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
