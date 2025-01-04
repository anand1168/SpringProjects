package com.selleniumexpress;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.selleniumexpress.entity.Employee;
import com.selleniumexpress.utils.Utility;

public class CreateApp {
	public static void main(String[] args) {

		SessionFactory sessionFactory = Utility.getSessionFactory();

		if (sessionFactory != null) {

			Session openSession = sessionFactory.openSession();

			Employee e1 = new Employee();
			e1.setEmpAge(44);
			e1.setEmpName("Anand");

			openSession.beginTransaction();

			openSession.save(e1);

			openSession.getTransaction().commit();

			openSession.close();

		}

	}

}
