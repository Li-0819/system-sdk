package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodSettingEditDTO;
import com.iris.model.dto.system.SysSignInMoodSettingListDTO;
import com.iris.model.entity.SysSignInMoodSetting;
import com.iris.model.vo.system.SysSignInMoodSettingVO;

/**
 * <p>
 * 签到心情配置信息 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysSignInMoodSettingService extends IService<SysSignInMoodSetting> {

    /**
     * 获取签到心情配置信息列表
     * @param sysSignInMoodSettingListDTO {@link SysSignInMoodSettingListDTO}
     * @return
     */
    PageResponseVO<SysSignInMoodSettingVO> getList(SysSignInMoodSettingListDTO sysSignInMoodSettingListDTO);

    /**
     * 编辑签到心情配置
     * @param sysSignInMoodSettingEditDTO {@link SysSignInMoodSettingEditDTO}
     */
    void edit(SysSignInMoodSettingEditDTO sysSignInMoodSettingEditDTO);

    /**
     * 校验签到心情配置信息是否重复
     * @param moodName 心情名称
     * @param moodCode  心情编码
     * @param id    签到心情配置信息ID
     * @return
     */
    boolean checkRepeat(String moodName, String moodCode, String id);
}
