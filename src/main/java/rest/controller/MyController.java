package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.Employee;
import rest.exceptionHandling.EmployeeIncorrectData;
import rest.exceptionHandling.NoSuchEmployeeException;
import rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("employee id = " + id + " not exists");
        }
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee insertEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String removeEmployee(@PathVariable("id") Long id) {
        employeeService.removeEmployee(id);
        return "Employee id " + id + " deleted.";
    }


}
