package com.iris.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class BaseVO {

    @Schema(name = "id", description = "主键")
    private String id;

    @Schema(name = "isDeleted", description = "是否可用")
    private Integer isDeleted;

    @Schema(name = "createdBy", description = "创建人")
    private String createdBy;

    @Schema(name = "createdTime", description = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdTime;

    @Schema(name = "modifiedBy", description = "编辑人")
    private String modifiedBy;

    @Schema(name = "modifiedTime", description = "编辑时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String modifiedTime;
}
