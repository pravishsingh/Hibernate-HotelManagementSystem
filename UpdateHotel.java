package com.prog;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateHotel {
	 public static void updateHotel() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter hotel ID to update :--->");
		 int id = sc.nextInt();
		 
		 sc.nextLine();// Consume new line
		 
		 System.out.println("Enter new hotel naem:");		 
		 String name= sc.nextLine();
		 
		 System.out.println("Enter new hotel address:----->");		 
		 String address= sc.nextLine();
		 
		 Configuration cfg = new Configuration();
		 cfg.configure("Crud.cfg.xml");
		 
		 try(SessionFactory factory = cfg.buildSessionFactory();
				 Session session = factory.openSession()){
			 
			 CreateHotel hotel = session.get(CreateHotel.class,id);
			 if(hotel == null) {
				 System.out.println("Hotel not found with ID:--->"+id);
				 
			 }
			 else {
				 hotel.sethName(name);
				 hotel.sethAddress(address);
				  Transaction tx = session.beginTransaction();
	                session.update(hotel);
	                tx.commit();
	                System.out.println("Hotel updated successfully!");
			 }
			 
		 }
		 catch (Exception e) {
	            System.out.println("Failed to update hotel: " + e.getMessage());
	        }
		 
		 
	 }

}
