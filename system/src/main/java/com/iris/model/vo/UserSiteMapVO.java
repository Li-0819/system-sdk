package com.iris.model.vo;

import lombok.Data;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 15:34
 * @Description: UserSiteMapVO
 */
@Data
public class UserSiteMapVO {

    private String id;
    private String patentId;
    private String name;
    private String url;
    private String siteMapLevel;
    private String code;
    private String codeName;
    private String type;
    private String typeName;
    private String iconClass;
}
