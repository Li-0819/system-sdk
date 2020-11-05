package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-01 09:48
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysOrganizationsMapBaseVO extends BaseVO {

    @Schema(name = "code", description = "机构编码")
    private String code;

    @Schema(name = "name", description = "机构名称")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "isLocked", description = "是否锁定")
    private Integer isLocked;
}
