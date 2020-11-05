package com.iris.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.EmployeeInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 员工信息 Mapper 接口
 * </p>
 *
 * @author WindChaser
 * @since 2020-09-18
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeInfoEntity> {
}
