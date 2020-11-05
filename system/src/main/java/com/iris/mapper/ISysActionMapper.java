package com.iris.mapper;

import com.iris.model.dto.system.SysActionListDTO;
import com.iris.model.vo.system.SysActionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author RubyWong
 * @date 2020/7/23 9:52
 * @description 按钮功能
 */
@Mapper
public interface ISysActionMapper {

    /**
     * 获取功能管理列表
     * @param sysActionListDTO {@link SysActionListDTO}
     * @return
     */
    List<SysActionVO> getList(@Param("sysActionListDTO") SysActionListDTO sysActionListDTO);

    /**
     * 获取功能管理详情
     * @param id {@link '功能管理ID'}
     * @return
     */
    SysActionVO getDetail(@Param("id") String id);
}
