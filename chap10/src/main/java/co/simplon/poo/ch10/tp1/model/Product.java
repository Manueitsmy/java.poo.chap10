package co.simplon.poo.ch10.tp1.model;

import lombok.Data;
import lombok.NonNull;
@Data

public class Product {
	public Product(String id, String name, String price) {
	}

	@NonNull
	private String id;
	@NonNull
	private String name;

	private int price;
}

