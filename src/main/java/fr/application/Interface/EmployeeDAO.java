package fr.application.Interface;

import java.util.List;
import fr.application.hocine2.Employee;
public interface EmployeeDAO {
Employee find(int id);
List<Employee> findBigestSalary(int salary);
List<Employee> findAll();
}
