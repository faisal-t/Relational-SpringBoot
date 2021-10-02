package com.faisal.restapispring.model.repository;

import com.faisal.restapispring.model.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

//    List<Product> findByNameCountains(String name);

}
