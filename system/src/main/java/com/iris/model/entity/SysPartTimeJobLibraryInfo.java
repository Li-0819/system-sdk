package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 职位描述素材库信息
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysPartTimeJobLibraryInfo对象", description="职位描述素材库信息")
public class SysPartTimeJobLibraryInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "classifyId", description = "分类(酒餐饮服务、电商仓储、快递物流、市场推广、会展执行、保安保洁、客服话务、校园代理、公益志愿、职能技术、观众充场、其他)")
    private String classifyId;

    @Schema(name = "content", description = "内容")
    private String content;

    @Schema(name = "useCounts", description = "使用次数")
    private Integer useCounts;

    @Schema(name = "sequence", description = "排序")
    private Integer sequence;

    @Schema(name = "remark", description = "备注")
    private String remark;

}
