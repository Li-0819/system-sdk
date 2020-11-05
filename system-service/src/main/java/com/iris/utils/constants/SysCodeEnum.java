package com.iris.utils.constants;

import lombok.Getter;

/**
 * @author izanagi
 * @version 1.0
 * @date 2020/8/26 18:14
 */
@Getter
public enum SysCodeEnum {

    /**
     * 打卡类型
     */
    CLOCK_IN_TYPE("1013", "打卡类型"),
    /**
     * 作息打卡
     */
    CLOCK_IN_TIME("1014", "作息打卡"),
    /**
     * 饮食打卡
     */
    CLOCK_IN_DIET("1015", "饮食打卡"),

    /**
     * 性别 type : 1002
     */
    GENDER_MALE("1002-10", "男"),
    GENDER_FEMALE("1002-20", "女"),
    GENDER_UNKNOWN ("1002-30", "未知");



    /**
     * code值
     */
    private String code;

    /**
     * 描述
     */
    private String description;


    SysCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
