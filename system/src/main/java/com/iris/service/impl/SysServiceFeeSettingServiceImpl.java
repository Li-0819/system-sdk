package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysServiceFeeSettingMapper;
import com.iris.mapper.SysServiceFeeSettingMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysServiceFeeSettingEditDTO;
import com.iris.model.dto.system.SysServiceFeeSettingListDTO;
import com.iris.model.entity.SysServiceFeeSetting;
import com.iris.model.vo.system.SysServiceFeeSettingVO;
import com.iris.service.ISysServiceFeeSettingService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务费分润比例设置 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysServiceFeeSettingServiceImpl extends ServiceImpl<SysServiceFeeSettingMapper, SysServiceFeeSetting> implements ISysServiceFeeSettingService {

    @Resource private ISysServiceFeeSettingMapper iSysServiceFeeSettingMapper;
    /**
     * 获取服务费分润比例设置
     * @param sysServiceFeeSettingListDTO {@link SysServiceFeeSettingListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysServiceFeeSettingVO> getList(SysServiceFeeSettingListDTO sysServiceFeeSettingListDTO) {

        PageHelper.startPage(sysServiceFeeSettingListDTO.getCurrentPage(), sysServiceFeeSettingListDTO.getPageSize());

        return PageResponseVO.of(iSysServiceFeeSettingMapper.getList(sysServiceFeeSettingListDTO), SysServiceFeeSettingVO.class);
    }

    /**
     * 校验服务费分润比例分类是否重复
     * @param settingType
     * @param id
     * @return
     */
    @Override
    public boolean checkTypeRepeat(String settingType, String id) {

        List<SysServiceFeeSetting> sysServiceFeeSettings = baseMapper.selectList(new QueryWrapper<SysServiceFeeSetting>() {{
            eq(SystemCommonField.SETTING_TYPE, settingType);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysServiceFeeSettings.size() > 0;
    }

    /**
     * 编辑服务费分润比例设置
     * @param sysServiceFeeSettingEditDTO {@link SysServiceFeeSettingEditDTO}
     */
    @Override
    public void edit(SysServiceFeeSettingEditDTO sysServiceFeeSettingEditDTO) {

        SysServiceFeeSetting sysServiceFeeSetting = DataTransferUtil.model(sysServiceFeeSettingEditDTO, new SysServiceFeeSetting());

        if (JudgeParam.isNullOrUndefined(sysServiceFeeSetting.getId())){

            baseMapper.insert(sysServiceFeeSetting);
        }else {

            SysServiceFeeSetting serviceFeeSetting = baseMapper.selectOne(new QueryWrapper<SysServiceFeeSetting>() {{
                eq(SystemCommonField.ID, sysServiceFeeSetting.getId())
                        .eq(SystemCommonField.IS_LOCKED, 0);
            }});

            JudgeParam.entityIsNotNull(serviceFeeSetting, SystemMsgConstants.SERVICE_FEE_NOT_EXIST);

            baseMapper.updateById(sysServiceFeeSetting);
        }
    }

    /**
     * 获取服务费分润比例详情
     * @param id 服务费分润比例ID
     * @return
     */
    @Override
    public SysServiceFeeSettingVO getDetail(String id) {

        return iSysServiceFeeSettingMapper.getDetail(id);
    }
}
