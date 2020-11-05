package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysIntegralSettingInfoEditDTO;
import com.iris.model.dto.system.SysIntegralSettingInfoListDTO;
import com.iris.model.entity.SysIntegralSettingInfo;
import com.iris.model.vo.system.SysIntegralSettingInfoVO;

/**
 * <p>
 * 积分配置信息 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysIntegralSettingInfoService extends IService<SysIntegralSettingInfo> {

    /**
     * 获取积分配置信息列表
     * @param sysIntegralSettingInfoListDTO {@link SysIntegralSettingInfoListDTO}
     * @return
     */
    PageResponseVO<SysIntegralSettingInfoVO> getList(SysIntegralSettingInfoListDTO sysIntegralSettingInfoListDTO);

    /**
     * 编码复合主键是否重复
     * @param integralName 积分名称
     * @param integralCode 积分编码
     * @param id 积分配置信息ID
     * @return
     */
    boolean checkNameAndCodeRepeat(String integralName, String integralCode, String id);

    /**
     * 编辑积分配置信息
     * @param sysIntegralSettingInfoEditDTO {@link SysIntegralSettingInfoEditDTO}
     */
    void edit(SysIntegralSettingInfoEditDTO sysIntegralSettingInfoEditDTO);

    /**
     * 获取积分配置信息详情
     * @param id 积分配置ID
     * @return
     */
    SysIntegralSettingInfoVO getDetail(String id);
}
