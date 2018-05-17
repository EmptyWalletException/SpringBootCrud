package com.kingguanzhang.crud.service;

import com.kingguanzhang.crud.mapper.DepartmentMapper;
import com.kingguanzhang.crud.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Collection<Department> getDepts() {
        Collection<Department> depts = departmentMapper.selectByExample(null);
        return depts;
    }
}
