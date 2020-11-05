package com.iris.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author ： Mr Liu
 * @Date ： 2019/5/11 16:58
 * @Description ： 上传附件返回信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AttachmentInfo", description = "文件上传返回数据")
public class AttachmentInfoVO {

    @Setter
    @Schema(name = "id", description = "文件id")
    private String id;

    @Schema(name = "sourceName", description = "文件原名")
    private String sourceName;

    @Schema(name = "targetName", description = "上传后文件名")
    private String targetName;

    @Schema(name = "halfDir", description = "文件半路径", hidden = true)
    private String halfDir;

    @Schema(name = "folder", description = "文件所在文件夹路径", hidden = true)
    private String folder;

    @Schema(name = "requestDir", description = "文件请求路径")
    private String requestDir;
}
