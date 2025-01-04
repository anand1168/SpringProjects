package com.selleniumexpress;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.selleniumexpress.entity.Employee;
import com.selleniumexpress.utils.Utility;

public class EmpNameQuery {

	public static void main(String[] args) {

		
		//getAllEmployees();
		//getEmployeeByAge(30);
		getEmployeeNameStartsWith("d%");
		

	}

	private static void getEmployeeNameStartsWith(String string) {
		
   Session session = Utility.getSessionFactory().openSession();
		
		session.createNamedQuery("Employee.GetEmpByName",Employee.class)
		.setParameter("substring", string).list().forEach(System.out::println);
		session.close();
		
		
	}

	private static void getEmployeeByAge(int i) {

		Session session = Utility.getSessionFactory().openSession();
		
		session.createNamedQuery("Employee.GetEmpByAge",Employee.class)
		.setParameter("AGE", i).list().forEach(System.out::println);
		session.close();
		
	}

	private static void getAllEmployees() {
		
		Session session = Utility.getSessionFactory().openSession();
		
		/*
		 * session.createNamedQuery("Employee.GetALL", Employee.class).
		 * getResultList().forEach(System.out::println);
		 */
		
		Query<Employee> query = session.createNamedQuery("Employee.GetALL", Employee.class);
		List<Employee> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		
		
		
		session.close();
		
		
	}

}
