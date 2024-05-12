package com.prog;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteHotel {
    public static void deleteHotel() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter hotel ID to delete:");
        int id = scanner.nextInt();

        Configuration cfg = new Configuration();
        cfg.configure("Crud.cfg.xml");
        
        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {
        	
            CreateHotel hotel = session.get(CreateHotel.class, id);
            
            if (hotel == null) {
                System.out.println("Hotel not found with ID: " + id);
            } else {
                Transaction tx = session.beginTransaction();
                session.delete(hotel);
                tx.commit();
                System.out.println("Hotel deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Failed to delete hotel: " + e.getMessage());
        }
    }
}
