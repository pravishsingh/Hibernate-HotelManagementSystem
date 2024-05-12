package com.prog;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Hotel Management System!");
		
		while(true) {
			System.out.println("Choose an option");
			System.out.println("1 To Create a new tabel");
			System.out.println("2 To Read hotel information");
			System.out.println("3 To Update hotel information");
			System.out.println("4 To Delete a hotel ");
			System.out.println("5 Exit");
			System.out.println("Enter your choice:-->");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				CreateHotel.createHotel();
				break;
            case 2:
                ReadHotel.readHotel();
                break;
            case 3:
                UpdateHotel.updateHotel();
                break;
            case 4:
                DeleteHotel.deleteHotel();
                break;
            case 5:
                System.out.println("Thank you for using Hotel Management System!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
				
			}
			
		}

	}

}
