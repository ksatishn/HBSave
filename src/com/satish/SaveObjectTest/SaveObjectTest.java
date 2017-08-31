package com.satish.SaveObjectTest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.satish.domain.Employee;

public class SaveObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = null;
		SessionFactory sf = null;
		Session sess = null;
		Transaction tx = null;
		Employee emp = null;
		
		cfg = new Configuration();
		
		cfg = cfg.configure("/com/satish/cfgs/hibernate.cfg.xml");
		
		sf = cfg.buildSessionFactory();
		try
		{
			sess = sf.openSession();
			tx = sess.beginTransaction();
			emp = new Employee();
			emp.setEid(999);
			emp.setEmail("satish@gmail.com");
			emp.setFirstName("satish");
			emp.setLastName("k");
			sess.save(emp);
			tx.commit();
			System.out.println("Object data saved/record updated");
		}catch (Exception e) {
			tx.rollback();
			System.out.println("Exception occured " + e);
			e.printStackTrace();
		}
		sess.close();
		sf.close();
	}
}
