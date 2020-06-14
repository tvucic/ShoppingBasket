package com.shopping.basket.component;


/*
 * 	Abstract class Product which represents product in gerneral
 */
public abstract class Product {
	
	// Every product should have price
	protected double price;
	
	// I could also use somethig like generateUniquId() method
	// but I hardcoded id in subclasses for sake of simplicity
	protected int id;

	// getter for id field
	public int getId() {
		return id;
	}
	
	public void setId(int ID) {
		this.id = ID;
	}

	// getter and setter for price field
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	// Info about product
	public void info() {
		System.out.println("ID " + getId() + ".  " + getClass().getSimpleName() 
				+ " price " + getPrice() + " on stock " + getNumOfProductsOnTheStock());
		System.out.println("------------------------------------");
	}

	public abstract int takeOutOfTheStockNew(int quantity);
	public abstract void putItOnTheStock(int quantity);
	public abstract int getNumOfProductsOnTheStock();
	public abstract int getInitNumOfProducts();


}
