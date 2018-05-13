package com.kingguanzhang.crud.service;

import com.kingguanzhang.crud.dao.DepartmentDao;
import com.kingguanzhang.crud.dao.EmployeeDao;
import com.kingguanzhang.crud.pojo.Department;
import com.kingguanzhang.crud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpService {

   @Autowired
   private EmployeeDao employeeDao;

   @Autowired
   private DepartmentDao departmentDao;

    public EmpService() {
    }


    public Collection<Employee> getEmps() {
        Collection<Employee> employees = employeeDao.getEmps();
        return employees;
    }

    public Collection<Department> getDepts() {
        Collection<Department> depts = departmentDao.getDepts();
        return depts;
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee getEmps(Integer id) {
        Employee employee = employeeDao.get(id);
        return employee;
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void delete(Integer id) {
        employeeDao.delete(id);
    }
}
