package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysSignInMoodSettingMapper;
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

import javax.annotation.Resource;
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

    @Resource private ISysSignInMoodSettingMapper iSysSignInMoodSettingMapper;

    /**
     * 获取签到心情配置信息列表
     * @param listDTO {@link SysSignInMoodSettingListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysSignInMoodSettingVO> getList(SysSignInMoodSettingListDTO listDTO) {

        PageHelper.startPage(listDTO.getCurrentPage(),listDTO.getPageSize());

        List<SysSignInMoodSettingVO> list = iSysSignInMoodSettingMapper.getList(listDTO);

        return PageResponseVO.of(list, SysSignInMoodSettingVO.class);
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

    /**
     * 获取签到心情配置信息详情
     * @param id ID
     * @return
     */
    @Override
    public SysSignInMoodSettingVO getDetail(String id) {

        return iSysSignInMoodSettingMapper.getDetail(id);
    }
}
