package com.iris.mapper;

import com.iris.model.vo.EnumProvinceDetailDropDownVO;
import com.iris.model.vo.SysCodeDropDownVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-20 01:22
 * @description NAME
 */
@Mapper
public interface ICommonSearchMapper {

    /**
     * 根据type获取系统编码数据
     * @param type 类型
     * @return
     */
    List<SysCodeDropDownVO> getSysCodeByType(@Param("type") String type);

    /**
     * 根据省份code下拉下级区域列表 (不传查询所有省)
     * @param code 省份Code
     * @return
     */
    List<EnumProvinceDetailDropDownVO> getAreaDropDownListByCode(@Param("code") String code);
}
