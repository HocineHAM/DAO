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
	private static String PASSWORD = "root";

	
	public Employee find(int id) {
		Employee emp = null;
		Statement stmt = null;
		Connection con = null;
		PreparedStatement pst;
		ResultSet rset = null;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.createStatement();
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee where EMP_ID = ?");
			pst.setInt(1, id);
			rset = pst.executeQuery();
			if (rset.next()) {
				emp = new Employee(id);
				emp.setName(rset.getString("EMP_NAME"));
				emp.setSalary(rset.getInt("SALARY"));
			}
		} catch (SQLException e) {
		}
		finally {
			try {
				if(rset!=null)
				rset.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	public List<Employee> findBigestSalary(int salary) {
		List<Employee> list = null;
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pst;
		ResultSet rset = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.createStatement();
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee where SALARY>?");
			pst.setInt(1, salary);
			rset = pst.executeQuery();
			while (rset.next()) {
				salary = rset.getInt("SALARY");
				String name = rset.getString("EMP_NAME");
				System.out.println("Mr " + name + "touche " + salary + " euros.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> findAll() {
		List<Employee> list = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		PreparedStatement pst;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			stmt = con.createStatement();
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM employee");
			rset = pst.executeQuery();
			while (rset.next()) {
				String name = rset.getString("EMP_NAME");
				System.out.println("M " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				System.out.println("voir les logs");
			}

		}

		return list;
	}

}
