package com.iris.model.vo.system;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: WindChaser
 * @create: 2020-11-04 15:00
 * @description: 职位描述素材库实体
 */
@Data
@Schema(name = "SysPartTimeJobLibraryInfoVO", description = "职位描述素材库实体")
public class SysPartTimeJobLibraryInfoVO extends BaseVO {

    @Schema(name = "classifyId", description = "分类(酒餐饮服务、电商仓储、快递物流、市场推广、会展执行、保安保洁、客服话务、校园代理、公益志愿、职能技术、观众充场、其他)")
    private String classifyId;

    @Schema(name = "classifyName", description = "分类名称")
    private String classifyName;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "useCounts", description = "使用次数")
    private Integer useCounts;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
