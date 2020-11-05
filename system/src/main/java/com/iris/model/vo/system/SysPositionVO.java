package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-31 13:33
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysPositionVO", description = "职位信息表")
public class SysPositionVO extends BaseVO {

    @Schema(name = "organizationsId", description = "机构编码")
    private String organizationsId;

    @Schema(name = "organizationsName", description = "机构编码名称")
    private String organizationsName;

    @Schema(name = "positionName", description = "机构名称")
    private String positionName;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
