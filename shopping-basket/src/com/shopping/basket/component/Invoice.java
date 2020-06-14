package com.shopping.basket.component;

import java.util.Map;

public class Invoice{
	
	public void displayContent(Basket basket) {
		Map<Product, Integer> map = basket.getMapProductQuantity();
		System.out.println("    INVOICE     ");
		System.out.println("-----------------------");
		 for(Map.Entry<Product, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue() + " items of " +  entry.getKey());
		}
		 System.out.print("-----------------------\n");
		 System.out.println(
				 String.format("Your total sum without discount : $%.2f",
						 basket.getTotalSum() + basket.getDiscount()));
		 
		 System.out.println(String.format("Your discount : $%.2f",basket.getDiscount()));
		 System.out.println(String.format("Your total is  $%.2f", basket.getTotalSum()) + "\n\n");

	}


}
