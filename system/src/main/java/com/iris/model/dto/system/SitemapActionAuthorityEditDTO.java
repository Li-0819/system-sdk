package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-24 16:56
 * @description NAME
 */
@Data
public class SitemapActionAuthorityEditDTO {

    @Schema(name = "id", description = "授权表ID")
    private String id;

    @NotBlank(message = SystemMsgConstants.AUTHORITY_TYPE_NOT_FOUNT)
    @Schema(name = "authorityType", description = "功能权限类型(菜单-sitemap/按钮-action)")
    private String authorityType;

    @NotBlank(message = SystemMsgConstants.SITEMAP_ACTION_ID_NOT_FOUNT)
    @Schema(name = "sitemapActionId", description = "授权功能ID")
    private String sitemapActionId;

    @NotBlank(message = SystemMsgConstants.AUTHORITY_TARGET_TYPE_NOT_FOUNT)
    @Schema(name = "authorityTargetType", description = "目标权限类型(User/Position/Role)")
    private String authorityTargetType;

    @Schema(name = "isAuthorised", description = "是否授权")
    private Integer isAuthorised;

    @Schema(name = "siteMapsMateDTOS", description = "子级菜单")
    private List<SiteMapsMateDTO> siteMapsMateDTOS;
}
