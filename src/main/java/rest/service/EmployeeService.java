package rest.service;

import rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(Long employeeId);
    public void removeEmployee(Long employeeId);
}
