package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest 
{
    public static void main(String[] args)
    {
		onetoOneMapping();
	}

	@SuppressWarnings("deprecation")
	private static void onetoOneMapping() {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   		Session session = sf.openSession();
   		session.beginTransaction();
   		
   		Address adr = new Address();
   		adr.setCountry("Nepal");
   		adr.setCity("pokhara");
   		adr.setState("Kathmandu");
   		
   		session.save(adr);
   		
   		Employee emp = new Employee();
   		emp.setFname("Aashisna");
   		emp.setLname("Thapaiya");
   		emp.setSalary(150000);
   		emp.setAddress(adr);
   		
   		session.save(emp);
   		session.getTransaction().commit();
   		session.close();
		
	}
}
