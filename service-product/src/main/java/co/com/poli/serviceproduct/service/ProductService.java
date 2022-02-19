package co.com.poli.serviceproduct.service;

import co.com.poli.serviceproduct.entities.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void delete(Product product);
    List<Product> findAll();
    Product findById(Long id);
}
