package co.simplon.poo.ch10.tp1.service;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.Product;

public interface ProductService {

	List<Product> findAllProducts();

	void disableProduct(String productId) throws Exception;

	void enableProduct(String productId) throws Exception;
}
