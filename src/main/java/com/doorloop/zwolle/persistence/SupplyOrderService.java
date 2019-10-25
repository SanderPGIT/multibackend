package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Supplier;
import com.doorloop.zwolle.domein.SupplyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyOrderService {
    @Autowired
    SupplyOrderRepository supplyOrderRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public Iterable<SupplyOrder> geefOrders(){
        return supplyOrderRepository.findAll();
    }

    public SupplyOrder addOrder(SupplyOrder supplyOrder, long supplier ){
        Supplier temp = supplierRepository.findById(supplier).get();
        supplyOrder.setSupplier(temp);
        return supplyOrderRepository.save(supplyOrder);

    }

    public void delOrder(Long id){
        supplyOrderRepository.deleteById(id);
    }
}
