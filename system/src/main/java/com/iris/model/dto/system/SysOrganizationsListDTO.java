package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-31 13:24
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysOrganizationsListDTO", description = "组织机构查询列表")
public class SysOrganizationsListDTO extends PageConditionDTO {

    @Schema(name = "code", description = "机构编码")
    private String code;

    @Schema(name = "name", description = "机构名称")
    private String name;

    @Schema(name = "parentId", description = "父节点ID")
    private String parentId;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
