package com.kingguanzhang.crud.controller;

import com.kingguanzhang.crud.pojo.Employee;
import com.kingguanzhang.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = (Collection<Employee>) empService.getEmps();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
