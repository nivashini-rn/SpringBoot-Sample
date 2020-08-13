package com.niva.ItechWeb.model;

public class Bio {
    String designation;
    String dept;
    Double salary;
    Integer experience;


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
}
