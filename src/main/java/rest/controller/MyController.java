package rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.entity.Employee;
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
        return employeeService.getEmployee(id);
    }

    /*
    @RequestMapping("/employeeInfo")
    public String employeeInfo(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employeeInfo";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employeeId") Long employeeId,
                                 Model model) {

        Employee employee = employeeService.getEmployee(employeeId);
        model.addAttribute("employee", employee);

        return "employeeInfo";
    }

    @RequestMapping("/removeEmployee")
    public String removeEmployee(@ModelAttribute("employeeId") Long employeeId) {
        employeeService.removeEmployee(employeeId);
        return "redirect:/";
    }

*/


}
