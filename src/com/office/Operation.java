package com.office;

import java.util.Scanner;

public class Operation {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("press 1 to insert values into table..");
			System.out.println("press 2 to select all the records....");
			System.out.println("press 3 to update the records......");
			System.out.println("press 4 to delete the data from table...");
			System.out.println("Enter your choice.....");
			choice=sc.nextInt();
			if(choice == 1) {
				Insert.insert();
			}else if(choice == 2) {
				Create.display();
			}else if(choice == 3) {
				Update.update();
			}else if(choice == 4) {
				Drop.delete();
			}
		}while(choice!=5);
	}

}
