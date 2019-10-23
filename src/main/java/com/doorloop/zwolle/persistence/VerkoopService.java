

package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Bestelling;
import com.doorloop.zwolle.domein.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerkoopService {
    @Autowired
    BestellingRepository bestellingRepository;

    @Autowired
    ProductRepository productRepository;

    public Iterable<Bestelling> geefMeAlleBestellingen(){
        return bestellingRepository.findAll();
    }

    public Bestelling saveBestelling(Bestelling bestelling){
        for(Product product : bestelling.getProducts()) {
            if (product.getStock() < bestelling.getAantal()) {
                System.out.println("product out of stock, reduce amount or choose other product");
                bestelling.removeProduct(product);
            } else {
                product.setStock(product.getStock() - bestelling.getAantal());
                productRepository.save(product);
            }
        }
        return bestellingRepository.save(bestelling);
    }

    public void remove(Long id){
        bestellingRepository.deleteById(id);
    }

}


