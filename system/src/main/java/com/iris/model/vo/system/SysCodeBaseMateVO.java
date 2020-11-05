package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-26 15:00
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysCodeBaseMateVO extends BaseVO {

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "value", description = "值")
    private String value;

    @Schema(name = "name", description = "名称")
    private String name;

    @Schema(name = "type", description = "类型")
    private String type;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

}
