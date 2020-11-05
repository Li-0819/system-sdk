package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-07-28 16:43
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysSignInMoodLibraryInfoClassificationVO", description = "签到心情图文素材库分类结果实体")
public class SysSignInMoodLibraryInfoClassificationVO extends BaseVO {

    @Schema(name = "code", description = "编码")
    private String code;

    @Schema(name = "name", description = "名称(普通用户/推广员/商户/服务商)")
    private String name;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
