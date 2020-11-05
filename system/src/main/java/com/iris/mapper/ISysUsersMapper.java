package com.iris.mapper;


import com.iris.model.dto.system.UserListDTO;
import com.iris.model.vo.system.UsersDetailVO;
import com.iris.model.vo.system.UsersListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Mapper
public interface ISysUsersMapper {

    /**
     * 用户组织机构表下所属用户及详情
     * @param userListDTO {@link UserListDTO}
     * @return
     */
    List<UsersListVO> getList(@Param("userListDTO") UserListDTO userListDTO);

    /**
     * 获取用户详情信息
     * @param id
     * @return
     */
    UsersDetailVO getDetail(@Param("id") String id);
}
