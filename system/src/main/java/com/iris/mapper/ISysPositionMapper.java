package com.iris.mapper;


import com.iris.model.dto.system.SysPositionListDTO;
import com.iris.model.vo.system.SysPositionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-31 16:29
 * @description NAME
 */
@Mapper
public interface ISysPositionMapper {

    /**
     * 获取职位信息列表
     * @param sysPositionListDTO {@link SysPositionListDTO}
     * @return
     */
    List<SysPositionVO> getList(@Param("sysPositionListDTO") SysPositionListDTO sysPositionListDTO);

    /**
     * 获取职位信息列表详情
     * @param id 职位信息ID
     * @return
     */
    SysPositionVO getDetail(@Param("id") String id);
}
