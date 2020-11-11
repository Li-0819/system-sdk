package com.iris.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-25 14:11
 * @description NAME
 */
@Data
public class AuthListDTO {

    @Schema(name = "targetIds", description = "目标权限ids")
    private List<String> targetIds;

    @Schema(name = "sitemapId", description = "菜单id")
    private String sitemapId;

    @Schema(name = "isPlatform", description = "是否是平台级别")
    private Integer isPlatform;

    @Schema(name = "orgClass", description = "机构类型")
    private String orgClass;

}
