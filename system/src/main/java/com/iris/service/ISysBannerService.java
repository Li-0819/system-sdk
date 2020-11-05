package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysBannerEditDTO;
import com.iris.model.dto.system.SysBannerListDTO;
import com.iris.model.entity.SysBanner;
import com.iris.model.vo.system.SysBannerVO;


/**
 * <p>
 * banner信息 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysBannerService extends IService<SysBanner> {

    /**
     * 获取banner信息列表
     * @param sysBannerListDTO {@link SysBannerListDTO}
     * @return
     */
    PageResponseVO<SysBannerVO> getList(SysBannerListDTO sysBannerListDTO);

    /**
     * 编辑banner信息
     * @param sysBannerEditDTO {@link SysBannerEditDTO}
     */
    void edit(SysBannerEditDTO sysBannerEditDTO);

    /**
     * 获取banner信息详情
     * @param id {@link 'banner信息ID'}
     * @return
     */
    SysBannerVO getDetail(String id);
}
