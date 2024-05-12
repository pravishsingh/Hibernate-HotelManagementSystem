package com.prog;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreateHotel {
	
	public static void createHotel() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter hotel name:");
		String name = sc.nextLine();
		
	    System.out.println("Enter hotel address:");
        String address = sc.nextLine();
		
		Configuration cfg = new Configuration();
		cfg.configure("Crud.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
        CreateHotel ch = new CreateHotel();
        ch.sethName(name);
        ch.sethAddress(address);
        
        try (Session session = factory.openSession()) {
        	Transaction tx = session.beginTransaction();
        	session.save(ch);
        	tx.commit();
            System.out.println("Hotel added successfully!");  	
        }
        catch(Exception e) {
            System.out.println("Failed to add hotel: " + e.getMessage());
        }
        
        finally {
        	 factory.close();
        }

		
		
	}
	
	
	@Id
	private int hId;
	
	private String hName;
	private String hAddress;
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
	
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethAddress() {
		return hAddress;
	}
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	public CreateHotel(int hId, String hName, String hAddress) {
		super();
		this.hId = hId;
		this.hName = hName;
		this.hAddress = hAddress;
	}
	public CreateHotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CreateHotel [hId=" + hId + ", hName=" + hName + ", hAddress=" + hAddress + "]";
	}
	
	
	
	
	

}
