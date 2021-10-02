package com.faisal.restapispring.model.repository;

import com.faisal.restapispring.model.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
