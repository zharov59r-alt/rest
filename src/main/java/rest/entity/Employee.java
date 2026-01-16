package rest.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee", schema = "public")
@SequenceGenerator(name = "s_employee_id", sequenceName = "s_employee_id", allocationSize = 1)
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_employee_id")
    private Long id;

    @NotEmpty
    @Column(name = "employee_name", columnDefinition = "text", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "employee_surname", columnDefinition = "text", nullable = false)
    private String surname;

    @Column(name = "employee_salary", columnDefinition = "text", nullable = false)
    private int salary;

    @Column(name = "employee_department", columnDefinition = "text", nullable = false)
    private String department;

    public Employee() {
    }

    public Employee(String name, String surname, int salary, String department) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
