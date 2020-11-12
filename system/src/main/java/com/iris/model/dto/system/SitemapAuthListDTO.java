package com.iris.model.dto.system;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-12 19:41
 * @description:
 */
@Data
public class SitemapAuthListDTO {

    private String type;
    private String targetId;
    private Integer isPlatform;
    private String orgClass;
    private List<String> filterActionKeys;

    private List<String> orgFiltration;
}
