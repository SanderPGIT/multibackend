package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository <Product, Long> {
    @Query ("SELECT u FROM Product u WHERE u.name = ?1")
    public List<Product> searchForName(String string);

}
