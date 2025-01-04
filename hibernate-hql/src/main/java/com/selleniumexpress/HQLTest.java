package com.selleniumexpress;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.selleniumexpress.entity.Employee;
import com.selleniumexpress.utils.Utility;

public class HQLTest {

	public static void main(String[] args) {

		// getAllEmployees();

		// getEmployeeByAge(32);

		// getEmployeeByAgeAndName(28,"SUCHITA");

		// getEmployeeNameAndId();

		//updateRecord(5, 42);
		
		getNumberOfEmployee();

	}
	
	
	
	
	

	private static void getNumberOfEmployee() {

		Session session = Utility.getSessionFactory().openSession();

		Query<Long> query = session.createQuery("Select count(*) from Employee", Long.class);
		List<Long> list = query.list();

		System.out.println(list);

	}






	private static void updateRecord(int id, int age) {

		String hql = "Update Employee set empAge=:AGE where id= :ID";

		Session session = Utility.getSessionFactory().openSession();
		Query query = session.createQuery(hql);

		query.setParameter("ID", id);
		query.setParameter("AGE", age);

		session.beginTransaction();

		int update = query.executeUpdate();

		session.getTransaction().commit();

		if (update > 0)
			System.out.println("Employee updated");
		else
			System.out.println("Updation failed");

		session.close();

	}

	private static void getEmployeeNameAndId() {

		String hql = "Select s.id, s.empName from Employee s";

		Session session = Utility.getSessionFactory().openSession();

		Query<Object[]> query = session.createQuery(hql, Object[].class);

		List<Object[]> list = query.list();

		for (Object[] tempObject : list) {

			for (Object obj : tempObject) {

				System.out.println(obj);
			}
		}

	}

	private static void getEmployeeByAgeAndName(int age, String name) {

		Session session = Utility.getSessionFactory().openSession();

		String hql = "FROM Employee ee where ee.empAge= ?1	 OR ee.empName= ?2 ";

		Query<Employee> query = session.createQuery(hql, Employee.class);

		query.setParameter(1, age);
		query.setParameter(2, name);

		List<Employee> list = query.list();
		for (Employee emp : list) {

			System.out.println(emp);
		}

		session.close();

	}

	public static void getEmployeeByAge(int age) {
		Session session = Utility.getSessionFactory().openSession();
		Query<Employee> query = session.createQuery("FROM Employee where empAge= ?1", Employee.class);

		query.setParameter(1, age);

		List<Employee> list = query.list();

		for (Employee emp : list) {

			System.out.println(emp);
		}

		session.close();
	}

	public static void getAllEmployees() {
		Session session = Utility.getSessionFactory().openSession();

		Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

		List<Employee> list = query.list();

		for (Employee emp : list) {

			System.out.println(emp);
		}

		session.close();
	}

}
