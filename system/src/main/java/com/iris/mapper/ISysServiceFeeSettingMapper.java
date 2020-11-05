package com.iris.mapper;


import com.iris.model.dto.system.SysServiceFeeSettingListDTO;
import com.iris.model.vo.system.SysServiceFeeSettingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-30 14:27
 * @description NAME
 */
@Mapper
public interface ISysServiceFeeSettingMapper {

    /**
     * 获取服务费分润比例设置列表
     * @param listDTO {@link SysServiceFeeSettingListDTO}
     * @return
     */
    List<SysServiceFeeSettingVO> getList(@Param("listDTO") SysServiceFeeSettingListDTO listDTO);

    /**
     * 获取服务费分润比例详情
     * @param id 服务费分润比例ID
     * @return
     */
    SysServiceFeeSettingVO getDetail(@Param("id") String id);
}
