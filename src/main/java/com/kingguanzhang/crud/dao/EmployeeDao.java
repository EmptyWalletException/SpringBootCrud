package com.kingguanzhang.crud.dao;

import com.kingguanzhang.crud.pojo.Department;
import com.kingguanzhang.crud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer,Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer,Employee>();

        employeeMap.put(1111,new Employee(1111,"刘备","1001@3kingdom.com",1,new Date(131233555245L),new Department(1,"蜀国")));
        employeeMap.put(1112,new Employee(1112,"关羽","1002@3kingdom.com",1,new Date(143454545245L),new Department(1,"蜀国")));
        employeeMap.put(1113,new Employee(1113,"张飞","1003@3kingdom.com",1,new Date(163454545245L),new Department(1,"蜀国")));
        employeeMap.put(1114,new Employee(1114,"赵云","1004@3kingdom.com",1,new Date(183454545245L),new Department(1,"蜀国")));
        employeeMap.put(1115,new Employee(1115,"黄忠","1005@3kingdom.com",1,new Date(23454545245L),new Department(1,"蜀国")));
        employeeMap.put(1116,new Employee(1116,"吕布","1006@3kingdom.com",1,new Date(263454545245L),new Department(2,"魏国")));
        employeeMap.put(1117,new Employee(1117,"貂蝉","1007@3kingdom.com",0,new Date(283454545245L),new Department(2,"魏国")));
    }

    public Collection<Employee> getEmps(){
        return employeeMap.values();
    }

    public Employee get(Integer id){
        return employeeMap.get(id);
    }

    public void  delete(Integer id){
        employeeMap.remove(id);
    }

    private static Integer initId = 1008;
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDept(departmentDao.getDepartment(employee.getDept().getId()));
        employeeMap.put(employee.getId(),employee);
    }

    public void update(Employee employee) {
        employeeMap.remove(employee.getId());
        employee.setDept(departmentDao.getDepartment(employee.getDept().getId()));
        employeeMap.put(employee.getId(),employee);
    }
}
