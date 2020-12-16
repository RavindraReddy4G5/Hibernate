package com.office;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Create {
	public static void display() throws Exception {
		Session se=Config.config();
		Transaction tx=se.beginTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice .....");
		System.out.println("======press 1 for to get all records=======");
		System.out.println("======press 2 for to get one record=======");
		int choice = sc.nextInt();
		if (choice == 1) {
			Query qr=se.createQuery("from Employee e");
			List<Employee> li=qr.list();
			Iterator<Employee> i=li.iterator();
			while (i.hasNext()) {
				Employee emp=i.next();
				System.out.println(
						"Employee [eid=" + emp.getEid() + ", name=" + emp.getEname() + ", salary=" + emp.getEsalary()
								+ ", companyName=" + emp.getEcomname() + ", designation=" + emp.getEdesignation() + ", bloodgroup="
								+ emp.getEbloodgroup() + ", phone=" + emp.getEphone() + ", age=" + emp.getEage() + ", gender=" + emp.getEgender()+"]");
			}
		} else if (choice == 2) {
			Query qr=se.createQuery("from Employee e where e.eid=:x");
			String option = "";
			do {
				System.out.println("enter employee id");
				qr.setParameter("x", sc.nextInt());
				List<Employee> li=qr.list();
				Iterator<Employee> i=li.iterator();
				while (i.hasNext()) {
					Employee emp=i.next();
					System.out.println(
							"Employee [eid=" + emp.getEid() + ", name=" + emp.getEname() + ", salary=" + emp.getEsalary()
							+ ", companyName=" + emp.getEcomname() + ", designation=" + emp.getEdesignation() 
							+ ", bloodgroup="+ emp.getEbloodgroup() + ", phone=" + emp.getEphone() 
							+ ", age=" + emp.getEage() + ", gender=" + emp.getEgender()+"]");
				}
				System.out.println("Do you want to continue (y/n): ");
				option = sc.next();
			} while (option.equalsIgnoreCase("y"));
		}
		tx.commit();
		se.close();
	}

}
