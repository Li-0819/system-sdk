package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-10-20 18:10
 * @description EmployeeVO
 */
@Data
public class EmployeeInfoVO {

    @Schema(description = "ID")
    private String id;

    @Schema(description = "员工名称")
    private String employeeName;

    @Schema(description = "员工编码")
    private String employeeCode;

    @Schema(description = "员工别名")
    private String employeeNoteName;

    @Schema(description = "员工类型")
    private String employeeClass;

    @Schema(description = "员工类型")
    private String employeeClassName;

    @Schema(description = "头像")
    private String avatar;
}
