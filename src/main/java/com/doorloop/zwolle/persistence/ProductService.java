package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> geefMeAlleProducten(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void remove(Long id){
        productRepository.deleteById(id);
    }
}
