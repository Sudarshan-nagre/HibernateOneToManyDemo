package com.sud.otm.client;

import java.util.Set;

import org.hibernate.Session;

import com.sud.otm.entity.Cart;
import com.sud.otm.entity.Items;
import com.sud.otm.util.HibernateUtil;

public class ClientSelect {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Cart cart = session.get(Cart.class, 1L);
		
		System.out.println(cart.getName());
		System.out.println(cart.getTotal());
		System.out.println("----------- Items -----------------");
		Set<Items> set= cart.getItems();
		
		for(Items i: set) {
			System.out.println(i.getItemId());
			System.out.println(i.getItemTotal());
			System.out.println(i.getQuantity());
			System.out.println("----------------------------");
		}
		
		session.close();
	}

}
