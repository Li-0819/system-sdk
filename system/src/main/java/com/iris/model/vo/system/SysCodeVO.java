package com.iris.model.vo.system;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysCodeVO", description = "系统代码返回实体")
public class SysCodeVO extends SysCodeBaseMateVO {

    @Schema(name = "children", description = "节点")
    private List<Children> children;
}
