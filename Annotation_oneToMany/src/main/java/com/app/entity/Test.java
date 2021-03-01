package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class Test {
	List<Address> addresses=new ArrayList<Address>();
	
	public void save() {
		Employee emp=new Employee();
		emp.setName("Rutuja");
		
		Address add1=new Address();
		add1.setCity("ukd");
		add1.setPincode(4457889);
		add1.setEmployee(emp);
		
		Address add2=new Address();
		add2.setCity("pune");
		add2.setPincode(3987897);
		add2.setEmployee(emp);
		
		List<Address> addresses=new ArrayList<Address>();
		addresses.add(add1);
		addresses.add(add2);
		emp.setAddresses(addresses);
		
		Session session=HibernateUtility.getSession().openSession();
		session.save(emp);
		session.beginTransaction().commit();
		System.out.println("Success");
		
	}
	
	@SuppressWarnings("unchecked")
	public void selectAll() {
	 HibernateUtility.getSession().openSession().createCriteria(Employee.class).list().forEach(System.out::println);
		
	}
	
	public void update() {
		Session session = HibernateUtility.getSession().openSession();
		Employee emp=(Employee) session.get(Employee.class, 34);
		emp.setName("Rohan");
		
		List<Address> address=new ArrayList<>();
		for (Address addr : emp.getAddresses()) {
			if(addr.getId()==47)
			addr.setCity("Surat");
			address.add(addr);
		}
		emp.setAddresses(address);      
		
		session.update(emp);

		session.beginTransaction().commit();
		System.out.println("Updated successfully");
	}
	
	
	public void delete() {
		Session session = HibernateUtility.getSession().openSession();
		Employee emp=(Employee) session.get(Employee.class, 33);
		session.delete(emp);
		session.beginTransaction().commit();
		System.out.println("Deleted successfully");
	}

	public static void main(String[] args) {

		Test t=new Test();
		//t.save();
	//	t.selectAll();
		t.update();
		//t.delete();
	}

}
