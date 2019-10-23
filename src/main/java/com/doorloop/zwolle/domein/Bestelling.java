
package com.doorloop.zwolle.domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bestellingid;

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    private int aantal;

    public long getId() {
        return bestellingid;
    }

    public void setId(long id) {
        this.bestellingid = id;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean removeProduct(Product product){
        return products.remove(product);
    }
}

