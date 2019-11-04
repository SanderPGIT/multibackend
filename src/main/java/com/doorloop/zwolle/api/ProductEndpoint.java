package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Afbeeldingdata;
import com.doorloop.zwolle.domein.Product;
import com.doorloop.zwolle.persistence.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductEndpoint {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public Iterable<Product> geefProducten() {
        return productService.geefMeAlleProducten();
    }

    @GetMapping("/product/zoeknaam")
    public List<Product> zoekProductOpNaam(@RequestParam String naamstring) {
        List<Product> result = productService.searchname(naamstring);
        return result;
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getproductvanid(@PathVariable long id) {
        return productService.geefproduct(id);
    }

    @PostMapping("/product")
    public Product extraproduct(@RequestBody Product product) {
        Product result = productService.save(product);
        return result;
    }

    @PostMapping("/product/{id}/image")
    public void addimage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("wezijn hier");
        Optional<Product> zonderafbeelding = productService.geefproduct(id);
        zonderafbeelding.get().setDatafoto(file.getBytes());
        productService.save(zonderafbeelding.get());
    }

    @DeleteMapping("/product/{id}")
    public void productweg(@PathVariable long id) {
        productService.remove(id);
    }

    @PutMapping("/product")
    public Product productchange(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @GetMapping("/order/{id}")
    public Optional<Product> getProductVanId(@PathVariable long id){
        return productService.geefproduct(id);
    }
}


