package com.shopping.basket.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.shopping.basket.product.Bread;
import com.shopping.basket.service.DisplayService;

/*
 *  Basket class represents basket of products
 */
public class Basket implements DisplayService{

	private double totalSum;
	private double discount;
	private Map<Product, Integer> mapProductQuantity;
	
	public Basket() {
		mapProductQuantity = new HashMap<>();
	}
	
	public void addNewProduct(Product product, int quantity) {
		
		// If item is already in the basket 
		if(mapProductQuantity.containsKey(product)) {

			// Removed value from basket
			int removedValue = mapProductQuantity.get(product);
			
			// Add to stock removed value
			product.putItOnTheStock(removedValue);
			
			// Move from basket
			mapProductQuantity.replace(product, 0);
			
			// Put in another value
			mapProductQuantity.put(product, quantity);
			
			
		}else {
			mapProductQuantity.put(product, quantity);	
		}
	}

	//www.geeksforgeeks.org/iterate-map-java/
	public void calculateBasketPrice(){
		
         // using for-each loop for iteration over Map.entrySet() 
		 double sum = 0.0;
         for (Map.Entry<Product, Integer> entry : mapProductQuantity.entrySet()) {
        	 int numOfItems = entry.getValue();
        	 double price = entry.getKey().getPrice();
        	 
        	 double currSum = 0.0;
        	 discount = calculateDiscount(entry.getKey());
        	 currSum = numOfItems*price - discount;
        	 sum += currSum;
         }
         totalSum = sum;
     }
	
	private double calculateDiscount(Product product) {
		double discount = 0.0;
		int productID = product.getId();
		switch (productID) {
		// Milk
		case 7:
			int numOfMilkInBasket = mapProductQuantity.get(product);
			int gratisMilk = numOfMilkInBasket / 4; // Quantity of milk for discount
			discount = gratisMilk*(product.getPrice());
			break;
		// Butter
		case 4:
			int numOfButters = mapProductQuantity.get(product);
			if(numOfButters >= 2 ) {
				//https://www.geeksforgeeks.org/hashmap-containsvalue-method-in-java/
				if(mapProductQuantity.containsKey(product)) {
					discount = (new Bread(1.00).getPrice()) * 0.5;
				}
			}
			break;
		}
		return discount;
	}

	private void displayBasketContent() {
		 System.out.println("Your basket contains:");
		 System.out.println("..............................");
		 for(Map.Entry<Product, Integer> entry : mapProductQuantity.entrySet()) {
		       System.out.println(entry.getValue() + " " + entry.getKey());
		       System.out.println("..............................");
		 }
	}

	public double getTotalSum() {
		return totalSum;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public void displayContent() {
		
		displayBasketContent();
	}

	public Map<Product, Integer> getMapProductQuantity() {
		return mapProductQuantity;
	}
	
}
