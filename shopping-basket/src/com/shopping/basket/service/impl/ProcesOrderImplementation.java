package com.shopping.basket.service.impl;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.shopping.basket.component.Basket;
import com.shopping.basket.component.Invoice;
import com.shopping.basket.component.Product;
import com.shopping.basket.starter.StarterImplementation;

public class ProcesOrderImplementation {

	// private fields
	private StarterImplementation starterImplementation;
	private static Character ans; // field for taking user answer
	private Scanner scanner;
	private Basket basket;
	// {product , productID}
	private Map<Product, Integer> mapUniquProducts;
	private Invoice invoice;
	private Product product;

	/*
	 * Initalizing fields in constructor
	 */
	public ProcesOrderImplementation() {
		scanner = new Scanner(System.in);
		basket = new Basket();
		invoice = new Invoice();
		mapUniquProducts = new HashMap<>();
		starterImplementation = new StarterImplementation();
	}

	public void processOrder() {
		starterImplementation.displayPrompt();
		do {
			try {
			System.out.println("\n> Select ID number to add product:");
			System.out.println("> Quit: q ");
			System.out.println("> Total: t \n>>");
			String data = scanner.next();
			ans = data.charAt(0);
			int input = Character.getNumericValue(ans);

			if (ans >= '1' && ans <= '8') {
				mapUniquProducts = starterImplementation.getMapOfUniqueProducts();
				if (mapUniquProducts.containsValue(input)) {
					product = returnProduct(mapUniquProducts, input);
					System.out.println("Select quantity: ");
					int quantity = scanner.nextInt();
					if (quantity < 0 || (quantity > product.getInitNumOfProducts())) {
						System.out.println("Select correct quantity!");
						continue;
					}

					// If there is enough items in the stock
					int status = product.takeOutOfTheStockNew(quantity);

					if (status == 1) {

						// {productID, Quantity}
						basket.addNewProduct(product, quantity);
						basket.displayContent();
						System.out.println();
						starterImplementation.displayUniqueProducts();
					}
				}
			}else if (ans == 't') {
				basket.calculateBasketPrice();
				invoice.displayContent(basket);
				starterImplementation.displayUniqueProducts();
			} else if((ans != 'q')){
				System.out.println("Invalid input");
				// Take the character from buffer
				scanner.nextLine();
			}
			}catch(InputMismatchException e) {
				System.out.println("Invalid input!");
				scanner.nextLine();
			}
		} while (ans != 'q');
		System.out.println("Thank you buy!");
	}

	/*
	 * https://www.techiedelight.com/get-map-key-from-value-java/
	 */
	private Product returnProduct(Map<Product, Integer> map, Integer productID) {
		for (Product p : map.keySet()) {
			if (productID.equals(map.get(p))) {
				return p;
			}
		}
		return null;
	}

}
