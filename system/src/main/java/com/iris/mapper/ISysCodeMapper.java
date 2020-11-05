package com.iris.mapper;

import com.iris.model.dto.system.SysCodeListDTO;
import com.iris.model.vo.system.SysCodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-26 14:18
 * @description NAME
 */
@Mapper
public interface ISysCodeMapper {

    /**
     * 获取数据字典列表
     * @param sysCodeListDTO {@link SysCodeListDTO}
     * @return
     */
    List<SysCodeVO> getList(@Param("sysCodeListDTO") SysCodeListDTO sysCodeListDTO);

    /**
     * 根据values获取名称拼接
     * @param values
     * @return
     */
    String getNameByValue(@Param("values") String[] values);
}
