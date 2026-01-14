package rest.service;

import rest.dao.EmployeeDAO;
import rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    };

    @Override
    @Transactional
    public Employee getEmployee(Long employeeId) {
        return employeeDAO.getEmployee(employeeId);
    }

    @Override
    @Transactional
    public void removeEmployee(Long employeeId) {
        employeeDAO.removeEmployee(employeeId);
    }

}
