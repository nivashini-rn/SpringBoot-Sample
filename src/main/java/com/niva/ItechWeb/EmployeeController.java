package com.niva.ItechWeb;

import com.niva.ItechWeb.model.Bio;
import com.niva.ItechWeb.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
;

import java.util.*;
@RestController
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

    @RequestMapping (value = "/employee/all")
    List<Employee> getEmployees(){
        List<Employee> employeeList = prepareData();
        return employeeList;
    }
    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Integer id)
    {
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList)
            if (employee.getId() == id)
            {
                ResponseEntity responseEntity = new ResponseEntity(employee, HttpStatus.OK);
                return responseEntity;
            }
        Map<String,String> map = new HashMap<>();
        map.put("message","Employee not found");
        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @RequestMapping(value = "/employee/create" , method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Employee employee)
    {
        addEmployee(employee);
        Map<String,String> map = new HashMap<>();
        map.put("message","Employee added Successfully");
        ResponseEntity responseEntity = new ResponseEntity(map,HttpStatus.CREATED);
        return responseEntity;
    }
    @RequestMapping(value = "/employee/update",method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@RequestBody Employee employee)
    {
        boolean updated = updateMyEmployee(employee);
        Map<String,String> map = new HashMap<>();
        ResponseEntity responseEntity;

        if(updated){
            map.put("message","Employee updated successfully");
            responseEntity = new ResponseEntity(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","Employee not found for update");
            responseEntity = new ResponseEntity(map,HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    private List<Employee> prepareData() {

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
    private void addEmployee(Employee employee) {
        List<Employee> employeeList = prepareData();
        employeeList.add(employee);
    }

    private boolean updateMyEmployee(Employee tobeUpdatedEmployee) {
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
