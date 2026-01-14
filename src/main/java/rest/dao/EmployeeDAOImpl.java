package rest.dao;

import rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.find(Employee.class, employeeId); // select по PK
        return employee;
    }

    @Override
    public void removeEmployee(Long employeeId) {
        Session session = sessionFactory.getCurrentSession();
        session.createMutationQuery("delete from Employee where id = :employee_id")
                .setParameter("employee_id", employeeId)
                .executeUpdate();
    }

}
