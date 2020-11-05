package com.iris.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author WindChaser
 * @createTime 2020-08-20 01:16
 * @description NAME
 */
@Data
@Schema(name = "SysCodeDropDownVO", defaultValue = "系统编码下拉数据列表")
public class SysCodeDropDownVO {

    private String id;

    @Schema(name = "值")
    private String value;

    @Schema(name = "名称")
    private String name;
}
