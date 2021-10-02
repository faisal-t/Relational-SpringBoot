package com.faisal.restapispring.service;

import com.faisal.restapispring.model.entities.Category;
import com.faisal.restapispring.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@TransactionScoped
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
//        if(category.getId()!=null){
//            Category currentCategory = categoryRepository.findById(category.getId()).get();
//            currentCategory.setName(category.getName());
//            category = currentCategory;
//        }
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()){
            return null;
        }
        return categoryRepository.findById(id).get();
    }

    public Iterable<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
