package com.iris.mapper;

import com.iris.model.dto.system.SysIntegralSettingInfoListDTO;
import com.iris.model.vo.system.SysIntegralSettingInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-04 16:48
 * @description:
 */
@Mapper
public interface ISysIntegralSettingInfoMapper {

    /**
     * 获取积分配置信息列表
     * @param listDTO {@link SysIntegralSettingInfoListDTO}
     * @return
     */
    List<SysIntegralSettingInfoVO> getList(@Param("listDTO") SysIntegralSettingInfoListDTO listDTO);

    /**
     * 获取积分配置信息详情
     * @param id 积分配置信息ID
     * @return
     */
    SysIntegralSettingInfoVO getDetail(@Param("id") String id);
}
