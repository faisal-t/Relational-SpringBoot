package com.faisal.restapispring.service;

import com.faisal.restapispring.model.entities.Product;
import com.faisal.restapispring.model.entities.Supliers;
import com.faisal.restapispring.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()){
            return null;
        }
        return productRepository.findById(id).get();
    }

    public Iterable<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

//    public List<Product> findProduct(String name){
//        return productRepository.findByNameCountains(name);
//    }

    public void addSuplier(Supliers supliers,Long productId){
        Product product = getProductById(productId);
        if (product == null){
            throw new RuntimeException("Product With Id"+productId+"not Found");
        }
        product.getSupliers().add(supliers);
        saveProduct(product);

    }


}
