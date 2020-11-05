package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-25 16:01
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SitemapsAuthListVO", description = "权限列表")
public class SitemapsAuthListVO extends SitemapsBaseVO{

    @Schema(name = "title", description = "标题")
    private String title;

    @Schema(name = "isAuth", description = "是否授权")
    private Integer isAuth;

    @Schema(name = "actionList", description = "菜单按钮二级列表")
    private List<Children> children;

    @Data
    @Schema(name = "Children", description = "权限二级菜单")
    public static class Children extends SitemapsBaseVO{

        @Schema(name = "title", description = "标题")
        private String title;

        @Schema(name = "isAuth", description = "是否授权")
        private Integer isAuth;

        @Schema(name = "ActionVO", description = "按钮列表")
        private List<ActionVO> actions;

        @Data
        @Schema(name = "ActionVO", description = "按钮")
        public static class ActionVO{

            @Schema(name = "id", description = "id")
            private String id;

            @Schema(name = "sitemapId", description = "菜单id")
            private String sitemapId;

            @Schema(name = "name", description = "名称")
            private String name;

            @Schema(name = "title", description = "标题")
            private String title;

            @Schema(name = "description", description = "描述")
            private String description;

            @Schema(name = "key", description = "键值")
            private String key;

            @Schema(name = "area", description = "区域")
            private String area;

            @Schema(name = "sequence", description = "排序")
            private Integer sequence;

            @Schema(name = "isAuth", description = "是否授权")
            private Integer isAuth;
        }
    }

}
