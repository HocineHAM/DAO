package fr.application.hocine2;



import fr.application.DAO.EmployeeDAOImpl;


public class Test {

	
	
		public static void main(String []args) throws Exception {
			
			EmployeeDAOImpl dao = new EmployeeDAOImpl();
			Employee result = dao.find(7499);
			Employee affiche = dao.find(7369);
			System.out.println(affiche);
			System.out.println(result);
//			
//			System.out.println(dao.findBigestSalary(900));
//			System.out.println(dao.findAll());
			
		}
	
		
		
		
	}

