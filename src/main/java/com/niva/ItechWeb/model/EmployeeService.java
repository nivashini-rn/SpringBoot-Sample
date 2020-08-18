package com.niva.ItechWeb.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public List<Employee> prepareData() {

        if(employeeList.isEmpty()) {
            Employee e1 = new Employee();
            e1.setId(1);
            e1.setName("Rama");
            Bio bio1 = new Bio();
            bio1.setDesignation("Sr.executive");
            bio1.setDept("Management");
            bio1.setSalary(200000.00);
            bio1.setExperience(3);

            e1.setBio(bio1);

            Employee e2 = new Employee();
            e2.setId(2);
            e2.setName("Niva");
            Bio bio2 = new Bio();
            bio2.setDesignation("Associative Software Engineer");
            bio2.setDept("IT");
            bio2.setSalary(90000.00);
            bio2.setExperience(1);
            e2.setBio(bio2);

            employeeList.add(e1);
            employeeList.add(e2);
        }
        return employeeList;
    }
    public void addEmployee(Employee employee) {
        List<Employee> employeeList = prepareData();
        employeeList.add(employee);
    }

    public boolean updateMyEmployee(Employee tobeUpdatedEmployee) {
        List<Employee> employeeList = prepareData();

        Iterator<Employee> iterator = employeeList.iterator();
        boolean removed = false;

        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee.getId() == tobeUpdatedEmployee.getId()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            employeeList.add(tobeUpdatedEmployee);
        }
        return removed;
    }
}
