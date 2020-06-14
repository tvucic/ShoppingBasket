package com.shopping.basket.product;

import com.shopping.basket.component.Product;
import com.shopping.basket.service.DisplayService;

public class Juice extends Product {
	
	private static int count;
	
	// How many Items is on the stock
	private static int numOfProductsOnTheStock;
	
	public Juice(double price) {
		this.price = price;
		this.id = 6;
		numOfProductsOnTheStock++;
		count++;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
//	@Override
//	public int takeOutOfTheStock(int quantity) {
//		int tempCount = count;
//		if(tempCount - quantity < 0) {
//			System.out.println("To high value. Out of stock. Select lower quantity.");
//			return -1;
//		}
//		count = count - quantity;
//		return 1;
//	}
	
	public int takeOutOfTheStockNew(int quantity) {
		if(quantity <= count) {
			numOfProductsOnTheStock -= quantity;
			return 1;
		}
		return -1;
	}

	@Override
	public int getNumOfProductsOnTheStock() {
		return numOfProductsOnTheStock;
	}
	
	@Override
	public void putItOnTheStock(int quantity) {
		numOfProductsOnTheStock += quantity;
	}

	@Override
	public int getInitNumOfProducts() {
		return count;
	}
}
