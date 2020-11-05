package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysServiceFeeSettingEditDTO;
import com.iris.model.dto.system.SysServiceFeeSettingListDTO;
import com.iris.model.entity.SysServiceFeeSetting;
import com.iris.model.vo.system.SysServiceFeeSettingVO;

/**
 * <p>
 * 服务费分润比例设置 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysServiceFeeSettingService extends IService<SysServiceFeeSetting> {

    /**
     * 获取服务费分润比例设置列表
     * @param sysServiceFeeSettingListDTO {@link SysServiceFeeSettingListDTO}
     * @return
     */
    PageResponseVO<SysServiceFeeSettingVO> getList(SysServiceFeeSettingListDTO sysServiceFeeSettingListDTO);

    /**
     * 校验服务费分润比例分类是否重复
     * @param settingType 服务费分润比例分类
     * @param id 服务费分润比例ID
     * @return
     */
    boolean checkTypeRepeat(String settingType, String id);

    /**
     * 编辑服务费分润比例
     * @param sysServiceFeeSettingEditDTO {@link SysServiceFeeSettingEditDTO}
     */
    void edit(SysServiceFeeSettingEditDTO sysServiceFeeSettingEditDTO);

    /**
     * 获取服务费分润比例详情
     * @param id 服务费分润比例ID
     * @return
     */
    SysServiceFeeSettingVO getDetail(String id);
}
