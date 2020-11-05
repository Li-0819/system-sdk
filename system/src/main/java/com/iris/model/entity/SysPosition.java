package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 职位信息表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysPosition对象", description="职位信息表")
public class SysPosition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "organizationsId", description = "机构编码")
    private String organizationsId;

    @Schema(name = "positionName", description = "机构名称")
    private String positionName;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
