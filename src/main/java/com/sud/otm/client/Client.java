package com.sud.otm.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sud.otm.entity.Cart;
import com.sud.otm.entity.Items;
import com.sud.otm.util.HibernateUtil;

public class Client {

	public static void main(String[] args) {

		Cart cart = new Cart();
		cart.setName("MyCart2");
		
		Items item1 = new Items("Pen", 10, 4);
		Items item2 = new Items("Mobile", 20, 3);
		
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); 
		itemsSet.add(item2);
		
		cart.setItems1(itemsSet);
		cart.setTotal(10*4 + 20*3);
		
		Session session = null;
		Transaction tx = null;
		try{
			//Get Session
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Session created");
			//start transaction
			tx = session.beginTransaction();
			//Save the Model object
			session.save(cart);
			session.save(item1);
			session.save(item2);
			//Commit transaction
			tx.commit();
			System.out.println("Cart1 ID="+cart.getId());
			System.out.println("item1 ID="+item1.getId());
			System.out.println("item2 ID="+item2.getId());
			
			session.close();
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
		}
	}

}
