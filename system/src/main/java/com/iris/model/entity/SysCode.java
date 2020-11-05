package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统代码
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysCode对象", description="系统代码")
public class SysCode extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "编码")
    private String code;

    @Schema(name = "值")
    private String value;

    @Schema(name = "名称")
    private String name;

    @Schema(name = "类型")
    private String type;

    @Schema(name = "排序")
    private Integer sequence;
}
