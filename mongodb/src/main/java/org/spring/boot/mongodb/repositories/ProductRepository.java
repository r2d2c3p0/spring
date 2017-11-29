package org.spring.boot.mongodb.repositories;


import org.spring.boot.mongodb.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    @Override
    Product findOne(String id);

    @Override
    void delete(Product deleted);
}