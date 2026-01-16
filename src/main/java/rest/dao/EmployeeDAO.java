package rest.dao;

import rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployee();
    public Employee insertEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee getEmployee(Long employeeId);
    public void removeEmployee(Long employeeId);
}
