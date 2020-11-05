package com.iris.mapper;

import com.iris.model.dto.system.SysAppVersionListDTO;
import com.iris.model.vo.system.SysAppVersionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-27 10:48
 * @description NAME
 */
@Mapper
public interface ISysAppVersionMapper {

    /**
     * 获取应用版本信息列表
     * @param sysAppVersionListDTO {@link SysAppVersionListDTO}
     * @return
     */
    List<SysAppVersionVO> getList(@Param("sysAppVersionListDTO") SysAppVersionListDTO sysAppVersionListDTO);

    /**
     * 获取应用版本信息详情
     * @param id
     * @return
     */
    SysAppVersionVO getDetail(@Param("id") String id);
}
