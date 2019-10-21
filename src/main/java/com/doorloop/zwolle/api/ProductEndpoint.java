package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Product;
import com.doorloop.zwolle.persistence.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductEndpoint {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public Iterable<Product> geefProducten(){
        return productService.geefMeAlleProducten();
    }

    @PostMapping("/product")
    public Product extraproduct(@RequestBody Product product){
        Product result = productService.save(product);
        return result;
    }

    @DeleteMapping("/product")
    public void productweg(@RequestBody Product product){
        productService.remove(product);
    }



}
