package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Product;
import com.doorloop.zwolle.domein.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ProductRepository productRepository;


    public Iterable<Supplier>geefAlleSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier linkSupplier(long supplierId, long productId){
            Product tempProduct = productRepository.findById(productId).get();
            Supplier tempSupplier = supplierRepository.findById(supplierId).get();
            tempSupplier.getProducts().add(tempProduct);
            return supplierRepository.save(tempSupplier);
    }

    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void delSupplier(Long id){
        supplierRepository.deleteById(id);
    }

    public Supplier geefSupplierByProduct(long id){
        //System.out.println(product.getName());
        Product product = productRepository.findById(id).get();
        Iterable<Supplier> leveraars = supplierRepository.findAll();
        for(Supplier supplierUitRepo:leveraars){
            for(int i=0;i<supplierUitRepo.getProducts().size();i++){
                if(supplierUitRepo.getProducts().get(i)==product){
                    return supplierUitRepo;
                }
            }

        }
        return null;
    }
}
