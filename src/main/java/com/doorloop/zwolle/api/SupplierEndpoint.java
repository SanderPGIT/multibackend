package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Supplier;
import com.doorloop.zwolle.persistence.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierEndpoint {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/supplier")
    public Iterable<Supplier>geefSuppliers(){
        return supplierService.geefAlleSuppliers();
    }

    @PostMapping("/supplier")
    public Supplier nieuweSupplier(@RequestBody Supplier supplier){
        Supplier result = supplierService.addSupplier(supplier);
        return result;
    }

    @PutMapping("/supplier/{supplierid}/{productid}")
    public Supplier linkSupplier(@PathVariable long supplierid, @PathVariable long productid){
        Supplier result = supplierService.linkSupplier(supplierid, productid);
        return result;
    }

    @DeleteMapping("/supplier/{id}")
    public void delSupplier(@PathVariable long id){
        supplierService.delSupplier(id);
    }

    @PutMapping("/supplier")
    public Supplier pasSupplierAan(@RequestBody Supplier supplier){
        System.out.println("aangeroepen");
        Supplier result = supplierService.addSupplier(supplier);
        return result;

    }
}
