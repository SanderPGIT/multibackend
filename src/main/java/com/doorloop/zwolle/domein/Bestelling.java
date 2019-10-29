
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

    @ManyToOne
    private Klant deklant;

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

    public Klant getDeklant() {
        return deklant;
    }

    public void setDeklant(Klant deklant) {
        this.deklant = deklant;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean removeProduct(Product product){
        return products.remove(product);
    }
}

