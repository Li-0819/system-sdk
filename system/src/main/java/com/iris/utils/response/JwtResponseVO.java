package com.iris.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 11:43
 * @Description: JwtResponseVO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseVO {

    /**
     * token 字段
     */
    private String token;
    /**
     * token类型
     */
    private String tokenType;

    public JwtResponseVO(String token) {
        this.token = token;
        this.tokenType = "Bearer";
    }
}
