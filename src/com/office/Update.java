package com.office;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Update {
	public static void update() throws Exception {
		Session se=Config.config();
		Scanner sc = new Scanner(System.in);
		int choice = 0,a = 0;
		String option = "";
		do {
			Transaction tx=se.beginTransaction();
			System.out.println("press 1 to update name....");
			System.out.println("press 2 to update salary...");
			System.out.println("press 3 to update designation...");
			System.out.println("press 4 to update phonenumber...");
			System.out.println("==========enter your choice......");
			choice=sc.nextInt();
			if (choice == 1) {
				Query qr=se.createQuery("update Employee e set e.ename=:x where e.eid=:y");
				System.out.println("Enter new name:");
				qr.setParameter("x", sc.next());
				System.out.println("enter employee id: ");
				qr.setParameter("y", sc.nextInt());
				a = qr.executeUpdate();
				if (a == 1)
					System.out.println("====== updated Sucess=======");
			} else if (choice == 2) {
				Query qr=se.createQuery("update Employee e set e.esalary=:x where e.eid=:y");
				System.out.println("Enter updated  salary:");
				qr.setParameter("x", sc.nextInt());
				System.out.println("enter the id of updated salary: ");
				qr.setParameter("y", sc.nextInt());
				a = qr.executeUpdate();
				if (a == 1)
					System.out.println("======= updated sucess=====");
			} else if (choice == 3) {
				Query qr=se.createQuery("update Employee e set e.edesignation=:x where e.eid=:y");
				System.out.println("Enter changed designation:");
				qr.setParameter("x", sc.next());
				System.out.println("enter the id to which department to be updated: ");
				qr.setParameter("y", sc.nextInt());
				a = qr.executeUpdate();
				if (a == 1)
					System.out.println("=======updated sucess======");
			 
			} else if (choice == 4) {
				Query qr=se.createQuery("update Employee e set e.ephone=:x where e.eid=:y");
				System.out.println("Enter new phone:");
				qr.setParameter("x", sc.next());
				System.out.println("enter the id to which phoneNumber to be updated: ");
				qr.setParameter("y", sc.nextInt());
				a = qr.executeUpdate();
				if (a == 1)
					System.out.println("====== updated sucess======");
			} 
			tx.commit();
			System.out.println("Do you want to continue (y/n)");
			option = sc.next();
		} while (option.equalsIgnoreCase("y"));
		se.close();
	}

}
