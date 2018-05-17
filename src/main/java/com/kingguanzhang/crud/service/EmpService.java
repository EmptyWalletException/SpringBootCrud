package com.kingguanzhang.crud.service;

import com.kingguanzhang.crud.mapper.EmployeeMapper;
import com.kingguanzhang.crud.pojo.Employee;
import com.kingguanzhang.crud.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmpService {

   @Autowired
   EmployeeMapper employeeMapper;



    public EmpService() {
    }


    public Collection<Employee> getEmps() {
        //这里限制一下查询的数据量
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdBetween(1,15);

        Collection<Employee> employees = employeeMapper.selectByExampleWithDept(employeeExample);
        return employees;
    }



    public void save(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(id);
        return employee;
    }

    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    public void delete(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
