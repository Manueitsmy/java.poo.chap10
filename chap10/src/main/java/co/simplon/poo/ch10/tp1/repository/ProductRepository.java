package co.simplon.poo.ch10.tp1.repository;

import co.simplon.poo.ch10.tp1.model.Product;

public interface ProductRepository {
Product getById(String id);
}
