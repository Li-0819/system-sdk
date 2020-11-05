package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.SysSignInMoodSettingMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodSettingEditDTO;
import com.iris.model.dto.system.SysSignInMoodSettingListDTO;
import com.iris.model.entity.SysSignInMoodSetting;
import com.iris.model.vo.system.SysSignInMoodSettingVO;
import com.iris.service.ISysSignInMoodSettingService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 签到心情配置信息 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysSignInMoodSettingServiceImpl extends ServiceImpl<SysSignInMoodSettingMapper, SysSignInMoodSetting> implements ISysSignInMoodSettingService {

    /**
     * 获取签到心情配置信息列表
     * @param sysSignInMoodSettingListDTO {@link SysSignInMoodSettingListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysSignInMoodSettingVO> getList(SysSignInMoodSettingListDTO sysSignInMoodSettingListDTO) {

        PageHelper.startPage(sysSignInMoodSettingListDTO.getCurrentPage(),sysSignInMoodSettingListDTO.getPageSize());

        List<SysSignInMoodSetting> sysSignInMoodSettings = baseMapper.selectList(new QueryWrapper<SysSignInMoodSetting>() {{

            if (!JudgeParam.isNullOrUndefined(sysSignInMoodSettingListDTO.getMoodName())) {

                like(SystemCommonField.MOOD_NAME, sysSignInMoodSettingListDTO.getMoodName());
            }

            if (!JudgeParam.isNullOrUndefined(sysSignInMoodSettingListDTO.getMoodCode())) {

                eq(SystemCommonField.MOOD_CODE, sysSignInMoodSettingListDTO.getMoodCode());
            }

            if (!JudgeParam.isNullOrUndefined(sysSignInMoodSettingListDTO.getThemeColor())) {
                eq(SystemCommonField.THEME_COLOR, sysSignInMoodSettingListDTO.getThemeColor());
            }
        }});

        return PageResponseVO.of(sysSignInMoodSettings, SysSignInMoodSettingVO.class);
    }

    /**
     * 编辑签到心情配置信息
     * @param sysSignInMoodSettingEditDTO {@link SysSignInMoodSettingEditDTO}
     */
    @Override
    public void edit(SysSignInMoodSettingEditDTO sysSignInMoodSettingEditDTO) {

        SysSignInMoodSetting sign = DataTransferUtil.model(sysSignInMoodSettingEditDTO, new SysSignInMoodSetting());

        if (JudgeParam.isNullOrUndefined(sign.getId())){

            baseMapper.insert(sign);
        } else {

            SysSignInMoodSetting sysSignInMoodSetting = baseMapper.selectById(sign.getId());

            JudgeParam.entityIsNotNull(sysSignInMoodSetting, SystemMsgConstants.SIGN_IN_MOOD_SETTING_NOT_FOUND);

            baseMapper.updateById(sign);
        }
    }

    /**
     * 校验参数是否重复
     * @param moodName 心情名称
     * @param moodCode  心情编码
     * @param id    签到心情配置信息ID
     * @return
     */
    @Override
    public boolean checkRepeat(String moodName, String moodCode, String id) {

        List<SysSignInMoodSetting> sysSignInMoodSettings = baseMapper.selectList(new QueryWrapper<SysSignInMoodSetting>(){{
            and(wrapper ->
                    wrapper.eq(SystemCommonField.MOOD_CODE, moodCode)
                            .or()
                            .eq(SystemCommonField.MOOD_NAME, moodName));

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysSignInMoodSettings.size() > 0;
    }
}
