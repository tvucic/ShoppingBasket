package com.shopping.basket.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shopping.basket.component.Product;
import com.shopping.basket.product.Apple;
import com.shopping.basket.product.Bannana;
import com.shopping.basket.product.Bread;
import com.shopping.basket.product.Butter;
import com.shopping.basket.product.Chips;
import com.shopping.basket.product.Juice;
import com.shopping.basket.product.Milk;
import com.shopping.basket.product.Soup;


public class StarterImplementation {
	
	private List<Product> products  = populateProducts();
	private Map<Product, Integer> mapOfUniqueProducts;
	
	public StarterImplementation() {
		
		uniqueProducts();
	}
	
	public void displayPrompt() {
		System.out.println("\n\tWELCOME TO OUR SHOP!\n");
		System.out.print("\n\tWhat would you like to buy?\n\n");
		displayUniqueProducts();
	}

	public void uniqueProducts() {
		mapOfUniqueProducts = new HashMap<Product, Integer>();
		for(Product product : products) {
			if(!mapOfUniqueProducts.containsValue(product.getId())) {
				mapOfUniqueProducts.put(product, product.getId());
			}
		}
	}

	public void displayUniqueProducts() {
		System.out.println("       --  ITEMS ON THE STOCK  --\n");
		for(Product product : mapOfUniqueProducts.keySet()) {
	    	product.info();
	    }
	}
	
	/*
	 *  Helper method to hardcode populate sample products
	 */
	private static List<Product> populateProducts() {
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Apple(1.20));
		listOfProducts.add(new Apple(1.20));
		listOfProducts.add(new Apple(1.20));
		listOfProducts.add(new Bread(1.00));
		listOfProducts.add(new Bread(1.00));
		listOfProducts.add(new Bread(1.00));
		listOfProducts.add(new Bread(1.00));
		listOfProducts.add(new Soup(2.20));
		listOfProducts.add(new Soup(2.20));
		listOfProducts.add(new Juice(1.80));
		listOfProducts.add(new Juice(1.80));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Milk(1.15));
		listOfProducts.add(new Bannana(0.75));
		listOfProducts.add(new Bannana(0.75));
		listOfProducts.add(new Bannana(0.75));
		listOfProducts.add(new Bannana(0.75));
		listOfProducts.add(new Chips(0.50));
		listOfProducts.add(new Chips(0.50));
		listOfProducts.add(new Chips(0.50));
		listOfProducts.add(new Chips(0.50));
		listOfProducts.add(new Butter(0.80));
		listOfProducts.add(new Butter(0.80));
		listOfProducts.add(new Butter(0.80));
		listOfProducts.add(new Butter(0.80));
		return listOfProducts;
	}
	
	public static void putItemsOnTheStock(int quantity) {
		
	}

	public Map<Product, Integer> getMapOfUniqueProducts() {
		return mapOfUniqueProducts;
	}

}
