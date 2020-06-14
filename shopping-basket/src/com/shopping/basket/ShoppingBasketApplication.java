package com.shopping.basket;

import com.shopping.basket.service.impl.ProcesOrderImplementation;


/*
 * 		Project using SOLID priciples
 * 		https://www.baeldung.com/solid-principles
 */
public class ShoppingBasketApplication {

	public static void main(String[] args) {
		
		new ProcesOrderImplementation().processOrder();
	}
}
