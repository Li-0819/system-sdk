package com.iris.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author RubyWong
 * @date 2020/7/14 11:04
 * @description CustomMapper
 */
public interface CustomMapper<T> extends BaseMapper<T> {

    /**
     * 根据ID逻辑删除通用方法
     * @param entity Model实体（必须：id， is_deleted， modified_by）
     * @return 删除行数
     */
    int logicDelete(T entity);

    /**
     * 根据ID数据回滚通用方法
     * @param entity Model实体（必须：id， is_deleted， modified_by）
     * @return 回滚条数
     */
    int recover(T entity);
}
