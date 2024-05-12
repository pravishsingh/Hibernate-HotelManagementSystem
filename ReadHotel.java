package com.prog;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

public class ReadHotel {
	public static void readHotel() {
		Configuration cfg = new Configuration();
		cfg.configure("Crud.cfg.xml");
		
        try (SessionFactory factory = cfg.buildSessionFactory();
                Session session = factory.openSession()) {
               // Executing an HQL query to retrieve all hotels
               Query<CreateHotel> query = session.createQuery("FROM CreateHotel", CreateHotel.class);
               List<CreateHotel> hotels = query.list();
               
               if (hotels.isEmpty()) {
                   System.out.println("No hotels found.");
               } else {
                   System.out.println("Hotel List:");
                   for (CreateHotel hotel : hotels) {
                       System.out.println(hotel);
                   }
               }
           } catch (Exception e) {
               System.out.println("Failed to read hotels: " + e.getMessage());
           }
		
		
	}



}
