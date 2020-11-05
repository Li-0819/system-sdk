package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysActionMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysActionEditDTO;
import com.iris.model.dto.system.SysActionListDTO;
import com.iris.model.entity.SysAction;
import com.iris.model.mapper.SysActionMapper;
import com.iris.model.vo.system.SysActionVO;
import com.iris.service.ISysActionService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * 功能管理 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysActionServiceImpl extends ServiceImpl<SysActionMapper, SysAction> implements ISysActionService {

    @Resource ISysActionMapper iSysActionMapper;

    /**
     * 获取功能管理列表
     * @param sysActionListDTO {@link SysActionListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysActionVO> getList(SysActionListDTO sysActionListDTO) {

        PageHelper.startPage(sysActionListDTO.getCurrentPage(),sysActionListDTO.getPageSize());

        return PageResponseVO.of(iSysActionMapper.getList(sysActionListDTO), SysActionVO.class);
    }

    /**
     * 编辑功能管理
     * @param sysActionEditDTO {@link SysActionEditDTO}
     */
    @Override
    public void edit(SysActionEditDTO sysActionEditDTO) {

        SysAction sysAction = DataTransferUtil.model(sysActionEditDTO, new SysAction());

        if (JudgeParam.isNullOrUndefined(sysAction.getId())){

            baseMapper.insert(sysAction);
        } else {

            SysAction selectOne = baseMapper.selectById(sysAction.getId());

            JudgeParam.entityIsNotNull(selectOne, SystemMsgConstants.ACTION_NOT_FOUND);

            baseMapper.updateById(sysAction);
        }
    }

    /**
     * 获取功能管理详情
     * @param id {@link '功能管理ID'}
     * @return
     */
    @Override
    public SysActionVO getDetail(String id) {

        return iSysActionMapper.getDetail(id);
    }

    /**
     * 校验功能管理key是否重复
     * @param key
     * @param id
     * @return
     */
    @Override
    public boolean checkKeyRepeat(String key, String id) {

        Integer integer = baseMapper.selectCount(new QueryWrapper<SysAction>() {{

            eq('`'+ SystemCommonField.KEY +'`', key);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return integer > 0;
    }
}
