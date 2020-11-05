package com.iris.model.vo;

import lombok.Data;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 15:32
 * @Description: UserOrganizationVO
 */
@Data
public class UserOrganizationVO {

    private String id;
    private String code;
    private String name;
    private String parentId;
    private String parentCode;
    private Integer isPlatform;
}
