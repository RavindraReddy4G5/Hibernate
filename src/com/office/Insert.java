package com.office;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Insert {
	public static void insert() throws Exception {
		Session se=Config.config();
		Scanner sc=new Scanner(System.in);
		String option="";
		do {
			Transaction tx=se.beginTransaction();
			Employee emp=new Employee();
			 System.out.println("enter employee id: ");
			   emp.setEid(sc.nextInt());
			    System.out.println("enter emploee name :");
			    emp.setEcomname(sc.next());
			    System.out.println("enter employee salary : ");
			    emp.setEsalary(sc.nextInt());
			    System.out.println("enter employee designation : ");
			    emp.setEdesignation(sc.next());
			    System.out.println("enter employee phone number : ");
			    emp.setEphone(sc.nextInt());
			    System.out.println("enter the employee bloodgroup :");
			    emp.setEbloodgroup(sc.next());
			    System.out.println("enter the employee age :");
			    emp.setEage(sc.nextInt());
			    System.out.println("enter employee company name :");
			    emp.setEcomname(sc.next());
			    System.out.println("enter gender");
			    emp.setEgender(sc.next());
			    Serializable s=se.save(emp);
			tx.commit();
			if(s.hashCode()>0) {
				System.out.println(" ...........inserted sucessfully......");
			}
			System.out.println("Do you want to continue (y/n): ");
			option=sc.next();
		}while(option.equalsIgnoreCase("y"));
		se.close();
	}


}
