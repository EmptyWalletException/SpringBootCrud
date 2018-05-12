package com.kingguanzhang.crud.pojo;

import java.util.Date;

public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Date birth;
    private Department dept;

    /*construstor*/
    public Employee() {
    }

    public Employee(Integer id, String name, String email, int gender, Date birth, Department deptId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.dept = dept;
    }

    /*set get*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
