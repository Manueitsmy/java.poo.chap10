package co.simplon.poo.ch10.tp1.service.impl;

import java.util.List;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private final ProductRepository products;

	public ProductServiceImpl(ProductRepository products) {

		super();
		this.products = products;

	}

	@Override
	public List<Product> findAllProducts() {
		return products.getById(productId);
	}

	@Override
	public void disableProduct(String productId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableProduct(String productId) throws Exception {
		// TODO Auto-generated method stub

	}

	public ProductRepository getProducts() {
		return products;
	}
}
