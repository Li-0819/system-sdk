package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: WindChaser
 * @create: 2020-11-04 15:25
 * @description: 编辑职位描述素材库
 */
@Data
public class SysPartTimeJobLibraryInfoEditDTO {

    @Schema(name = "id", description = "职位描述素材库ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.CLASSIFY_ID)
    @Schema(name = "classifyId", description = "分类(酒餐饮服务、电商仓储、快递物流、市场推广、会展执行、保安保洁、客服话务、校园代理、公益志愿、职能技术、观众充场、其他)")
    private String classifyId;

    @NotBlank(message = SystemMsgConstants.CONTENT)
    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "useCounts", description = "使用次数")
    private Integer useCounts;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;
}
