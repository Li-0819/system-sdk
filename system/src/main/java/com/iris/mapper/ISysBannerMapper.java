package com.iris.mapper;


import com.iris.model.dto.system.SysBannerListDTO;
import com.iris.model.vo.system.SysBannerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-23 16:56
 * @description ISysBannerMapper
 */
@Mapper
public interface ISysBannerMapper {

    /**
     * 获取banner信息列表
     * @param sysBannerListDTO {@link SysBannerListDTO}
     * @return
     */
    List<SysBannerVO> getList(@Param("sysBannerListDTO") SysBannerListDTO sysBannerListDTO);

    /**
     * 获取banner信息详情
     * @param id {@link 'banner信息ID'}
     * @return
     */
    SysBannerVO getDetail(@Param("id") String id);
}
