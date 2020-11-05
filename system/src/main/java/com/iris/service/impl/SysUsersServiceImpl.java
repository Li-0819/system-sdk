package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ICommonMapper;
import com.iris.mapper.ISysUsersMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.UserEditDTO;
import com.iris.model.dto.system.UserListDTO;
import com.iris.model.entity.SysUsers;
import com.iris.model.mapper.SysUsersMapper;
import com.iris.model.vo.system.UsersDetailVO;
import com.iris.model.vo.system.UsersListVO;
import com.iris.service.ICommonService;
import com.iris.service.ISysUsersService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements ISysUsersService {

    @Resource private ISysUsersMapper iSysUsersMapper;

    @Resource private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource private ICommonMapper iCommonMapper;

    @Resource private ICommonService iCommonService;

    @Value("${user.loginPwd}")
    private String loginPwd;

    /**
     * 用户组织机构表下所属用户及详情
     * @param userListDTO {@link UserListDTO}
     * @return
     */
    @Override
    public PageResponseVO<UsersListVO> getList(UserListDTO userListDTO) {

        PageHelper.startPage(userListDTO.getCurrentPage(), userListDTO.getPageSize());

        List<UsersListVO> UsersListVO = iSysUsersMapper.getList(userListDTO);

        return PageResponseVO.of(UsersListVO, UsersListVO.class);
    }

    /**
     * 校验登陆名是否重复
     * @param loginName 登陆名
     * @param id 用户ID
     * @return
     */
    @Override
    public boolean checkLoginNameRepeat(String loginName, String id) {

        List<SysUsers> sysUsers = baseMapper.selectList(new QueryWrapper<SysUsers>() {{
            eq(SystemCommonField.LOGIN_NAME, loginName);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysUsers.size() > 0;
    }

    /**
     * 编辑用户信息
     * @param userEditDTO {@link UserEditDTO}
     */
    @Override
    public void edit(UserEditDTO userEditDTO) {

        SysUsers sysUsers = DataTransferUtil.model(userEditDTO, new SysUsers());

        if (JudgeParam.isNullOrUndefined(sysUsers.getId())){

            String password = bCryptPasswordEncoder.encode(JudgeParam.isNullOrUndefined(sysUsers.getLoginPwd()) ? loginPwd : sysUsers.getLoginPwd());

            sysUsers.setLoginPwd(password);

            baseMapper.insert(sysUsers);
        }else {

            SysUsers user = baseMapper.selectOne(new QueryWrapper<SysUsers>() {{
                eq(SystemCommonField.ID, sysUsers.getId())
                        .eq(SystemCommonField.IS_LOCKED, 0);
            }});

            JudgeParam.entityIsNotNull(user, SystemMsgConstants.USER_NOT_EXIST);

            baseMapper.updateById(sysUsers);

            iCommonService.deleteUserRelevance(sysUsers.getId(), SystemCommonField.ROLE);
            iCommonService.deleteUserRelevance(sysUsers.getId(), SystemCommonField.POSITION);
        }

        if (null != userEditDTO.getRoleIds() && userEditDTO.getRoleIds().size() > 0){

            iCommonMapper.insertUserInRoles(sysUsers.getId(), userEditDTO.getRoleIds());
        }

        if (null != userEditDTO.getPositionIds() && userEditDTO.getPositionIds().size() > 0){

            iCommonMapper.insertUserInPosition(sysUsers.getId(), userEditDTO.getPositionIds());
        }
    }

    /**
     * 获取用户详情
     * @param id 用户ID
     * @return
     */
    @Override
    public UsersDetailVO getDetail(String id) {

        return iSysUsersMapper.getDetail(id);
    }
}
