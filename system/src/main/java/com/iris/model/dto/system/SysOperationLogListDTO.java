package com.iris.model.dto.system;


import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-30 17:55
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysOperationLogListDTO", description = "获取后台系统操作记录列表")
public class SysOperationLogListDTO extends PageConditionDTO {

    @Schema(name = "operationTitle", description = "操作标题")
    private String operationTitle;

    @Schema(name = "requestParams", description = "请求参数")
    private String requestParams;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
