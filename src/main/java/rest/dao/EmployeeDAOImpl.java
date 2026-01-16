package rest.dao;

import lombok.extern.slf4j.Slf4j;
import rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
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
    public Employee insertEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
        return employee;
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

        log.info("EmployeeDAOImpl.removeEmployee begin");
        session.createMutationQuery("delete from Employee where id = :employee_id")
                .setParameter("employee_id", employeeId)
                .executeUpdate();

        log.info("EmployeeDAOImpl.removeEmployee begin");
    }

}
