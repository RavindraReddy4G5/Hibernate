package com.office;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Drop {
	public static void delete() throws Exception {
		Session se=Config.config();
		Scanner sc=new Scanner(System.in);
		System.out.println("press 1 to delete all the data....");
		System.out.println("press 2 to delete one row...");
		System.out.println("enter your choice....");
		int choice = sc.nextInt();
		if (choice == 1) {
			Transaction tx=se.beginTransaction();
			Query qr=se.createQuery("delete from Employee e");
			int a = qr.executeUpdate();
			tx.commit();
			if (a == 0)
				System.out.println("all rows deleted====");
		} else if (choice == 2) {
			Query qr=se.createQuery("delete from Employee e where e.eid=:y");
			String option = "";
			do {
				Transaction tx=se.beginTransaction();
				System.out.println("enter eid of deleting employee");
				qr.setParameter("y", sc.nextInt());
				int a = qr.executeUpdate();
				tx.commit();
				if (a == 1)
					System.out.println("===== Delete sucess======");
				System.out.println("Do you want to continue (y/n): ");
				option = sc.next();
			} while (option.equalsIgnoreCase("y"));
		}
		se.close();
	}

}
