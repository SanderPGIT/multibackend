package com.doorloop.zwolle.domein;



import javax.persistence.*;

@Entity
public class SupplyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long id;
    int Amount;
    boolean Delivered;
    @OneToOne
    Supplier supplier;
    @OneToOne
    Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public boolean isDelivered() {
        return Delivered;
    }

    public void setDelivered(boolean delivered) {
        Delivered = delivered;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
