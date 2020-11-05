package com.iris.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.iris.utils.constants.SystemCommonField;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @Author: izanagi
 * @Date: 2020-07-11 15:58
 * @Description: MyMetaObjectHandle
 */
@Component
public class MyMetaObjectHandle implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object loginName;

        if (authentication != null) {

            loginName = JSONObject.parseObject(JSONObject.toJSONString(authentication.getPrincipal())).getString(SystemCommonField.ENTITY_FIELD_LOGIN_NAME);
        } else {

            //TODO 测试使用 后期修改
            loginName = metaObject.getValue(SystemCommonField.ID);
        }

        this.setFieldValByName(SystemCommonField.ENTITY_FIELD_CREATED_BY, loginName, metaObject);
        this.setFieldValByName(SystemCommonField.ENTITY_FIELD_MODIFIED_BY, loginName, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object loginName;

        if (authentication != null) {

            loginName = JSONObject.parseObject(JSONObject.toJSONString(authentication.getPrincipal())).getString(SystemCommonField.ENTITY_FIELD_LOGIN_NAME);
        } else {

            //TODO 测试使用 后期修改
            loginName = metaObject.getValue(SystemCommonField.ID);
        }

        this.setFieldValByName(SystemCommonField.ENTITY_FIELD_MODIFIED_BY, loginName, metaObject);
    }
}
