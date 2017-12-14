package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Department;
import com.wzu.oa.common.entity.DTO.SecondDepartment;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface DepartmentMapper extends Mapper<Department> {

    List<Department> findFirstDept();

    List<SecondDepartment> findDepartmentListLevel2ByParentId(Integer did);

    Integer deleteDepartment(Integer did) throws Exception;
}