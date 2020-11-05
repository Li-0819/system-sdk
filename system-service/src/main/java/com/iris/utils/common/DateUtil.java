package com.iris.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author ： Mr Liu
 * @Date ： 2019/5/11 16:06
 * @Description ： 日期工具类
 */
public class DateUtil {

    /**
     * 获取当前时间 - Mr Liu
     * @return 当前时间
     */
    public static String getNowTime(String format){

        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return df.format(localDate);
    }

    public static String getAttachName() {

        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return df.format(localDate);
    }

    public static long getTimeMillis(String time) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return df.parse(time).getTime();
    }
}
