package com.iris.mapper;

import com.iris.model.dto.system.SysOperationLogListDTO;
import com.iris.model.vo.system.SysOperationLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 */
@Mapper
public interface ISysOperationLogMapper {

    /**
     * 获取后台系统操作记录列表
     * @param dto {@link SysOperationLogListDTO}
     * @return
     */
    List<SysOperationLogVO> getList(@Param("dto") SysOperationLogListDTO dto);
}
