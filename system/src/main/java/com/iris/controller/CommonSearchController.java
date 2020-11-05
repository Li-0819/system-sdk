package com.iris.controller;

import com.iris.model.vo.EnumProvinceDetailDropDownVO;
import com.iris.model.vo.SysCodeDropDownVO;
import com.iris.service.ICommonSearchService;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-20 01:06
 * @description NAME
 */
@Tag(name = "Common", description = "通用查询")
@RestController
@RequestMapping("/common/search")
public class CommonSearchController {

    @Resource private ICommonSearchService iCommonSearchService;

    @Operation(summary = "根据type获取系统编码数据", tags = "Common")
    @GetMapping("/getSysCodeByType")
    public ResponseVO<List<SysCodeDropDownVO>> getSysCodeByType(@RequestParam(value = "type") String type){

        List<SysCodeDropDownVO> sysCodeDropDownVOS = iCommonSearchService.getSysCodeByType(type);

        return ResponseVO.ok(sysCodeDropDownVOS);
    }

    @Deprecated
    @Operation(summary = "根据省份code下拉下级区域列表 (不传查询所有省) -- WindChaser", tags = "Common")
    @GetMapping("/getAreaDropDownListByCode")
    public ResponseVO<List<EnumProvinceDetailDropDownVO>> getAreaDropDownListByCode(@RequestParam(value = "code", required = false) String code){

        List<EnumProvinceDetailDropDownVO> list = iCommonSearchService.getAreaDropDownListByCode(code);

        return ResponseVO.ok(list);
    }
}
