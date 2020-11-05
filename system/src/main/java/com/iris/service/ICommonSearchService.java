package com.iris.service;

import com.iris.model.vo.EnumProvinceDetailDropDownVO;
import com.iris.model.vo.SysCodeDropDownVO;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-20 01:11
 * @description NAME
 */
public interface ICommonSearchService {

    /**
     * 根据type获取系统编码数据
     * @param type 分类
     * @return
     */
    List<SysCodeDropDownVO> getSysCodeByType(String type);

    /**
     * 根据省份code下拉下级区域列表 (不传查询所有省)
     * @param code 省份Code
     * @return
     */
    List<EnumProvinceDetailDropDownVO> getAreaDropDownListByCode(String code);
}
