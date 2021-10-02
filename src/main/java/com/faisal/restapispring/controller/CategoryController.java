package com.faisal.restapispring.controller;

import com.faisal.restapispring.dto.CategoryData;
import com.faisal.restapispring.dto.ResponseData;
import com.faisal.restapispring.model.entities.Category;

import com.faisal.restapispring.model.entities.Product;
import com.faisal.restapispring.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody CategoryData categoryData, Errors errors){

        ResponseData<Category> responseData = new ResponseData<>();

        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }

        Category category = modelMapper.map(categoryData,Category.class);
        responseData.setStatus(true);
        responseData.setPayload(categoryService.saveCategory(category));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(@Valid @RequestBody Category category, Errors errors){
        ResponseData responseData = new ResponseData();
        if (errors.hasErrors()){
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(categoryService.saveCategory(category));
        System.out.println(responseData);


        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public String removeOne(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "Sucees Delete Product";
    }





}
