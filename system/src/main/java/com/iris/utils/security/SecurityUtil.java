package com.iris.utils.security;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.iris.exception.CustomException;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 16:09
 * @Description: security
 */
public class SecurityUtil {

    public static JSONObject getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JSONObject result = new JSONObject();

        if (authentication != null) {

            Object userInfo = authentication.getPrincipal();

            if (userInfo != null) {

                result = JSONObject.parseObject(JSONObject.toJSONString(userInfo));
            }
        }

        return result;
    }

    /**
     * 获取当前用户ID
     * @return userId
     */
    public static String currentUserId() {

        String userId = getCurrentUser().getString(SystemCommonField.ID);

        if (StrUtil.isBlank(userId)) {

            throw new CustomException(SystemMsgConstants.USER_INFO_NOT_FOUND);
        }

        return userId;
    }
}
