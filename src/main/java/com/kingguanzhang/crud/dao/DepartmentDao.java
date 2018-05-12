package com.kingguanzhang.crud.dao;

import com.kingguanzhang.crud.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer,Department> department= null;


    static {
        department = new HashMap<Integer,Department>();

        department.put(1,new Department(1,"蜀国"));
        department.put(2,new Department(2,"魏国"));
        department.put(3,new Department(3,"吴国"));
    }

    public Department getDepartment(Integer id){
        return department.get(id);
    }

}

