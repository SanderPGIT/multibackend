package com.doorloop.zwolle.domein;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int stock;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] datafoto;


    public byte[] getDatafoto() {
        return datafoto;
    }

    public void setDatafoto(byte[] datafoto) {
        this.datafoto = datafoto;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
