package com.iris.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-27 14:22
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "EnumProvinceDetailDropDownVO", description = "省市区下拉列表")
public class EnumProvinceDetailDropDownVO extends AreaBaseVO{

    @Schema(name = "EnumTown", description = "城市数据")
    private List<EnumCity> enumCityList;

    @Data
    public static class EnumCity extends AreaBaseVO{

        @Schema(name = "EnumCity", description = "区县数据")
        private List<EnumCounty> enumCityList;

        @Data
        public static class EnumCounty extends AreaBaseVO{

//            @Schema(name = "EnumCounty", description = "街道数据")
//            private List<EnumProvinceDetailDropDownVO.EnumCity.EnumCounty.EnumTown> enumCityList;
//
//            @Data
//            public static class EnumTown extends AreaBaseVO{
//            }
        }
    }
}
