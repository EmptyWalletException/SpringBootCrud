package com.kingguanzhang.crud.service;

import com.kingguanzhang.crud.dao.EmployeeDao;
import com.kingguanzhang.crud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class EmpService {

   @Autowired
   private EmployeeDao employeeDao;

    public EmpService() {
    }


    public Collection<Employee> getEmps() {
        Collection<Employee> employees = employeeDao.getEmps();
        return employees;
    }
}
