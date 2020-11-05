package com.iris.model.dto.system;

import com.iris.model.PageConditionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: WindChaser
 * @create: 2020-11-04 14:54
 * @description: 获取职位描述素材库
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysPartTimeJobLibraryInfoListDTO", description = "获取职位描述素材库")
public class SysPartTimeJobLibraryInfoListDTO extends PageConditionDTO {

    @Schema(name = "classifyId", description = "分类(酒餐饮服务、电商仓储、快递物流、市场推广、会展执行、保安保洁、客服话务、校园代理、公益志愿、职能技术、观众充场、其他)")
    private String classifyId;

    @Schema(name = "startTime", description = "开始时间")
    private String startTime;

    @Schema(name = "endTime", description = "结束时间")
    private String endTime;
}
