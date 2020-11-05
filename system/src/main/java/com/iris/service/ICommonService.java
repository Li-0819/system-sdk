package com.iris.service;

import org.springframework.lang.NonNull;

/**
 * @author WindChaser
 * @createTime 2020-08-26 10:27
 * @description NAME
 */
public interface ICommonService {

    /**
     * 根据不同的关联类型删除不同的 关联表
     * @param userId 用户ID
     * @param relevanceType 关联类型  position/roles/organization ...
     */
    void deleteUserRelevance(String userId, @NonNull String relevanceType);
}
