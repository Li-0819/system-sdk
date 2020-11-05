package com.iris.utils.common;

/**
 * <p>
 * REST API 错误码接口
 * </p>
 *
 * @package: com.business.fruit.common
 * @description: REST API 错误码接口
 * @author: RubyWong
 * @date: Created in 2019-12-07 14:35
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: RubyWong
 */
public interface IStatusUtil {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();

}