package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Product;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> geefMeAlleProducten(){
        return productRepository.findAll();
    }

    public Optional<Product> geefproduct(Long id){ return productRepository.findById(id);}

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void remove(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> searchname(String string) {
        return productRepository.searchForName(string);
        }


    }

