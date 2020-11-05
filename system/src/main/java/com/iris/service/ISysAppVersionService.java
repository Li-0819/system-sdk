package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppVersionEditDTO;
import com.iris.model.dto.system.SysAppVersionListDTO;
import com.iris.model.entity.SysAppVersion;
import com.iris.model.vo.system.SysAppVersionVO;

/**
 * <p>
 * 应用版本信息 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysAppVersionService extends IService<SysAppVersion> {

    /**
     * 获取应用版本信息列表
     * @param sysAppVersionListDTO {@link SysAppVersionListDTO}
     * @return
     */
    PageResponseVO<SysAppVersionVO> getList(SysAppVersionListDTO sysAppVersionListDTO);

    /**
     * 编辑应用版本信息
     * @param sysAppVersionEditDTO {@link SysAppVersionEditDTO}
     */
    void edit(SysAppVersionEditDTO sysAppVersionEditDTO);

    /**
     * 获取应用版本信息详情
     * @param id {@link "应用版本信息ID"}
     * @return
     */
    SysAppVersionVO getDetail(String id);

    /**
     * 校验应用版本信息是否重复
     * @param appName 应用名称
     * @param appCode 应用编码
     * @param id 应用版本信息
     * @return
     */
    boolean checkRepeat(String appName, String appCode, String id);
}
