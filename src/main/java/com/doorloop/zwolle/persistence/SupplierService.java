package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Iterable<Supplier>geefAlleSuppliers(){
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }

    public void delSupplier(Long id){
        supplierRepository.deleteById(id);
    }
}
