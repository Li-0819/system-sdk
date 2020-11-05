package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-08-26 11:45
 * @description NAME
 */
@Data
public class PositionBaseVO {

    @Schema(name = "id", description = "ID")
    private String id;

    @Schema(name = "organizationsId", description = "机构编码")
    private String organizationsId;

    @Schema(name = "positionName", description = "机构名称")
    private String positionName;
}
