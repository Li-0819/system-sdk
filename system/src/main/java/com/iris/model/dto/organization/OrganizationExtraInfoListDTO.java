package com.iris.model.dto.organization;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-12 14:30
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "OrganizationExtraInfoListDTO", description = "获取机构信息列表")
public class OrganizationExtraInfoListDTO extends PageConditionDTO {

    @Schema(name = "parentId", description = "隶属机构ID")
    private String parentId;

    @Schema(name = "organizationName", description = "机构名称")
    private String organizationName;

    @Schema(name = "organizationClass", description = "机构类型(自营/医院)")
    private String organizationClass;

    @Schema(name = "organizationSize", description = "机构规模")
    private String organizationSize;

    @Schema(name = "organizationStatus", description = "机构状态")
    private String organizationStatus;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;

}
