package com.iris.service.impl;


import com.alibaba.fastjson.JSON;
import com.iris.mapper.ICommonSearchMapper;
import com.iris.model.vo.EnumProvinceDetailDropDownVO;
import com.iris.model.vo.SysCodeDropDownVO;
import com.iris.service.ICommonSearchService;
import com.iris.utils.constants.SystemCommonField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-20 01:11
 * @description NAME
 */
@Service
public class CommonSearchServiceIpl implements ICommonSearchService {

    @Resource private ICommonSearchMapper iCommonSearchMapper;

    @Resource private StringRedisTemplate stringRedisTemplate;


    @Value("${area.key.offset}")
    private Long enumOffset;

    /**
     * 根据type获取系统编码数据
     * @param type 类型
     * @return
     */
    @Override
    public List<SysCodeDropDownVO> getSysCodeByType(String type) {

        return iCommonSearchMapper.getSysCodeByType(type);
    }

    /**
     * 根据省份code下拉下级区域列表 (不传查询所有省)
     * @param code 省份Code
     * @return
     */
    @Override
    public List<EnumProvinceDetailDropDownVO> getAreaDropDownListByCode(String code) {

        List<EnumProvinceDetailDropDownVO> areaDropDownListByCode;
        String key = SystemCommonField.AREA + code;
        Boolean bo = stringRedisTemplate.hasKey(key);

        long start = System.currentTimeMillis();

        if (bo){
            String str = stringRedisTemplate.opsForValue().get(key);

            areaDropDownListByCode = JSON.parseArray(str,EnumProvinceDetailDropDownVO.class);

        }else {
            areaDropDownListByCode = iCommonSearchMapper.getAreaDropDownListByCode(code);

            String s = JSON.toJSONString(areaDropDownListByCode);

            stringRedisTemplate.opsForValue().set(key, s, enumOffset);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间============:  "+(end-start)+"ms =====================");

        return areaDropDownListByCode;
    }
}
