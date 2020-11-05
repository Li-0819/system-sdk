package com.iris.mapper;

import com.iris.model.vo.UserRoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统代码 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-06-03
 */
@Mapper
public interface AuthUserMapper {

    /**
     * 用户角色
     * @param userId 用户ID
     * @return {@link UserRoleVO}
     */
    List<UserRoleVO> getRoles(@Param("userId") String userId);
}
