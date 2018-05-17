package com.kingguanzhang.crud.controller;

import com.kingguanzhang.crud.pojo.Department;
import com.kingguanzhang.crud.pojo.Employee;
import com.kingguanzhang.crud.service.DeptService;
import com.kingguanzhang.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @Autowired
    DeptService deptService;

    @GetMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = (Collection<Employee>) empService.getEmps();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmpPage(Model model){
        Collection<Department> depts = deptService.getDepts();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        empService.save(employee);
        return "redirect:/emps";
    }

    /**
     * list页面点击新增按钮或修改按钮后跳转到新增/修改页面并带上相关员工和所有部门的方法;
     * @param id
     * @param model
     * @return
     */
    //th:href="@{/emp}+${emp.id}"
    @GetMapping("/emp/{id}")
    public String toAddEmpPage(@PathVariable Integer id,Model model){
        Employee employee = empService.getEmp(id);
        Collection<Department> depts = deptService.getDepts();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String update(Employee employee){
        empService.update(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        empService.delete(id);
        return "redirect:/emps";
    }
}
