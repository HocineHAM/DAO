package fr.application.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import fr.application.Interface.EmployeeDAO;
import fr.application.hocine2.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con = null;
	private static String URL = "jdbc:mysql://localhost:3306/employee";
	private static String LOGIN = "root";
	private static String PASSWORD = "123456";

	public Employee find(int id) throws Exception {

		Connection con;
		
		con = DriverManager.getConnection(URL, LOGIN, PASSWORD);

		Statement stmt = con.createStatement();
		// ResultSet rset = stmt.executeQuery("SELECT * FROM employee where EMP_ID =
		// 'id'");

		PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee where EMP_ID = ?");
		Employee emp = null;
		pst.setInt(1, id);
		ResultSet rset = pst.executeQuery();
		if (rset.next()) {
			emp = new Employee(id);
			emp.setName(rset.getString("EMP_NAME"));
			emp.setSalary(rset.getInt("SALARY"));

		}
		rset.close();
		stmt.close();
		con.close();

		return emp;

	}

	public List<Employee> findBigestSalary(int salary) throws SQLException {

		Connection con;

		con = DriverManager.getConnection(URL, LOGIN, PASSWORD);

		Statement stmt = con.createStatement();
		

		PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee where SALARY>?");

		pst.setInt(1, salary);
		ResultSet rset = pst.executeQuery();
		while (rset.next()) {

			salary = rset.getInt("SALARY");
			String name = rset.getString("EMP_NAME");
			System.out.println("Mr " + name + "touche " + salary + " euros.");
			
		}
		rset.close();
		stmt.close();
		con.close();

		return null ;
	}
	
	public List<Employee> findAll() throws SQLException{
		
		Connection con;

		con = DriverManager.getConnection(URL, LOGIN, PASSWORD);

		Statement stmt = con.createStatement();
		

		PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee");

		
		ResultSet rset = pst.executeQuery();
		while (rset.next()) {

			String name = rset.getString("EMP_NAME");
			System.out.println("Mr " + name );
			
		}
		rset.close();
		stmt.close();
		con.close();

		
		return null ;
	}

}
