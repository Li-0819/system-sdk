package com.iris.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.iris.utils.constants.SystemCommonField;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Author: izanagi
 * @Date: 2020-03-18 17:38
 * @Description: DeleteMethod
 */
public class DeleteMethod extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        StringBuffer sql = new StringBuffer();
        sql.append("update ").append(tableInfo.getTableName());
        sql.append(" set ").append(SystemCommonField.IS_DELETED).append(" = 1, ");
        sql.append(SystemCommonField.MODIFIED_BY).append(" = #{modifiedBy}, ");
        sql.append(SystemCommonField.MODIFIED_TIME).append(" = now() ");
        sql.append("where ").append(SystemCommonField.ID).append(" = #{id} and ").append(SystemCommonField.IS_DELETED).append(" = 0");

        String method = "logicDelete";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql.toString(), modelClass);

        return addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
