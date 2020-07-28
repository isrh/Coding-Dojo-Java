package com.ignaciorivera.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignaciorivera.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{

		List<Product> findAll();
}
