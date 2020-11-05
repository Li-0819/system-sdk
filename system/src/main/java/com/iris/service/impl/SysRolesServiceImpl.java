package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysRolesMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysRolesEditDTO;
import com.iris.model.dto.system.SysRolesListDTO;
import com.iris.model.entity.SysRoles;
import com.iris.model.mapper.SysRolesMapper;
import com.iris.model.vo.system.SysRolesVO;
import com.iris.service.ISysRolesService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements ISysRolesService {

    @Resource private ISysRolesMapper iSysRolesMapper;

    /**
     * 获取角色管理列表
     * @param sysRolesListDTO {@link SysRolesListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysRolesVO> getList(SysRolesListDTO sysRolesListDTO) {

        PageHelper.startPage(sysRolesListDTO.getCurrentPage(), sysRolesListDTO.getPageSize());

        List<SysRolesVO> sysRoles = iSysRolesMapper.getList(sysRolesListDTO);

        return PageResponseVO.of(sysRoles, SysRolesVO.class);
    }

    /**
     * 校验角色是否重复
     * @param code 编码
     * @param name 名称
     * @param id 角色ID
     * @return
     */
    @Override
    public boolean checkRepeat(String code, String name, String id) {

        List<SysRoles> sysRoles = baseMapper.selectList(new QueryWrapper<SysRoles>() {{
            eq(SystemCommonField.CODE, code).eq(SystemCommonField.NAME, name);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysRoles.size() > 0;
    }

    /**
     * 编辑角色信息
     * @param sysRolesEditDTO {@link SysRolesEditDTO}
     */
    @Override
    public void edit(SysRolesEditDTO sysRolesEditDTO) {

        SysRoles sysRoles = DataTransferUtil.model(sysRolesEditDTO, new SysRoles());

        if (JudgeParam.isNullOrUndefined(sysRoles.getId())){

            baseMapper.insert(sysRoles);
        }else {

            SysRoles roles = baseMapper.selectOne(new QueryWrapper<SysRoles>() {{
                eq(SystemCommonField.IS_LOCKED, 0)
                        .eq(SystemCommonField.ID, sysRoles.getId());
            }});

            JudgeParam.entityIsNotNull(roles, SystemMsgConstants.ROLE_NOT_EXIST);

            baseMapper.updateById(sysRoles);
        }
    }

    @Override
    public SysRolesVO getDetail(String id) {

        return  iSysRolesMapper.getDetail(id);
    }
}
