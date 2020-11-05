package com.iris.model.vo;

import com.iris.utils.common.IStatusUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: izanagi
 * @Date: 2020-03-28 18:03
 * @Description: DeleteOrRecover
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DeleteOrRecover implements IStatusUtil {

    /**
     * 删除
     */
    DELETE(1, "action of delete"),

    /**
     * 恢复
     */
    RECOVER(2, "action of recover");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    @Override
    public String toString() {
        return String.format(" Status:{code=%s, message=%s} ", getCode(), getMessage());
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
