package com.iris.model;

import com.alibaba.fastjson.JSONObject;
import com.iris.model.vo.DeleteOrRecover;
import com.iris.utils.constants.SystemCommonField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author: izanagi
 * @Date: 2020-03-27 16:27
 * @Description: ModelForDeleteOrRecover
 */
@Data
@NoArgsConstructor
public class ModelForDeleteOrRecover {

    private String id;

    private Integer isDeleted;

    private String modifiedBy;

    public ModelForDeleteOrRecover(String id, DeleteOrRecover action) {

        if (DeleteOrRecover.DELETE.equals(action)) {

            this.isDeleted = 1;
        } else {

            this.isDeleted = 0;
        }

        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.id = id;
        this.modifiedBy = JSONObject.parseObject(JSONObject.toJSONString(object)).getString(SystemCommonField.ID);
    }
}
