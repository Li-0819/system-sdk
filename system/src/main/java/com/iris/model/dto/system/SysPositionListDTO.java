package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-31 16:08
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysPositionListDTO", description = "职位信息列表")
public class SysPositionListDTO extends PageConditionDTO {

    @Schema(name = "organizationsId", description = "机构编码")
    private String organizationsId;

    @Schema(name = "positionName", description = "机构名称")
    private String positionName;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
