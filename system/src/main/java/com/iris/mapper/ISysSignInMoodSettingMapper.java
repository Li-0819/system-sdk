package com.iris.mapper;

import com.iris.model.dto.system.SysSignInMoodSettingListDTO;
import com.iris.model.vo.system.SysSignInMoodSettingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-05 14:25
 * @description: 签到心情配置信息mapper
 */
@Mapper
public interface ISysSignInMoodSettingMapper {

    /**
     * 获取签到心情配置信息列表
     * @param listDTO {@link SysSignInMoodSettingListDTO}
     * @return
     */
    List<SysSignInMoodSettingVO> getList(@Param("listDTO") SysSignInMoodSettingListDTO listDTO);

    /**
     * 获取签到心情配置信息详情
     * @param id ID
     * @return
     */
    SysSignInMoodSettingVO getDetail(@Param("id") String id);
}
