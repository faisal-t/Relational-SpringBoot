package com.faisal.restapispring.controller;

import com.faisal.restapispring.dto.ResponseData;
import com.faisal.restapispring.model.entities.Product;
import com.faisal.restapispring.model.entities.Supliers;
import com.faisal.restapispring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){
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
        responseData.setPayload(productService.saveProduct(product));


        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product,Errors errors){
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
        responseData.setPayload(productService.saveProduct(product));


        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public String removeOne(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "Sucees Delete Product";
    }

    @PostMapping("/{id}")
    public void addSuplier(@RequestBody Supliers supliers,@PathVariable("id") Long productId){
        productService.addSuplier(supliers,productId);
    }


}
