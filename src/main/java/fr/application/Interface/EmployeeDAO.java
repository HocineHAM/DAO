package fr.application.Interface;

import java.sql.SQLException;
import java.util.List;

import fr.application.hocine2.Employee;

public interface EmployeeDAO {
Employee find(int id) throws Exception;
List<Employee> findBigestSalary(int salary) throws SQLException;
List<Employee> findAll() throws SQLException;
}
