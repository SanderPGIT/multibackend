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

    @GetMapping("/product/zoeknaam")
    public Product zoekProductOpNaam(@RequestParam String naamstring){
        Product result= productService.searchname(naamstring);
        return result;
    }

    @PostMapping("/product")
    public Product extraproduct(@RequestBody Product product){
        Product result = productService.save(product);
        return result;
    }

    @DeleteMapping("/product/{id}")
    public void productweg(@PathVariable long id){
        productService.remove(id);
    }

    @PutMapping("/product")
    public Product productchange(@RequestBody Product product){
        productService.save(product);
        System.out.println("het is gelukt");
        return product;
    }
}
