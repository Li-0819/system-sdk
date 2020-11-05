package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.UserEditDTO;
import com.iris.model.dto.system.UserListDTO;
import com.iris.model.entity.SysUsers;
import com.iris.model.vo.system.UsersDetailVO;
import com.iris.model.vo.system.UsersListVO;


/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysUsersService extends IService<SysUsers> {

    /**
     * 用户组织机构表下所属用户及详情
     * @param userListDTO {@link UserListDTO}
     * @return
     */
    PageResponseVO<UsersListVO> getList(UserListDTO userListDTO);

    /**
     * 校验登陆名是否重复
     * @param loginName 登陆名
     * @param id 用户ID
     * @return
     */
    boolean checkLoginNameRepeat(String loginName, String id);

    /**
     * 编辑用户信息
     * @param userEditDTO {@link UserEditDTO}
     */
    SysUsers edit(UserEditDTO userEditDTO);

    /**
     * 获取用户详情
     * @param id 用户ID
     * @return
     */
    UsersDetailVO getDetail(String id);

}
