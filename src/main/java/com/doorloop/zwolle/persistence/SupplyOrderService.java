package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Product;
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
    @Autowired
    ProductRepository productRepository;

    public Iterable<SupplyOrder> geefOrders(){
        return supplyOrderRepository.findAll();
    }

    public SupplyOrder addOrder(SupplyOrder supplyOrder, long supplier, long productId){
        Supplier tempSupplier = supplierRepository.findById(supplier).get();
        supplyOrder.setSupplier(tempSupplier);
        Product tempProduct = productRepository.findById(productId).get();
        supplyOrder.setProduct(tempProduct);
        return supplyOrderRepository.save(supplyOrder);

    }

    public void delOrder(Long id){
        supplyOrderRepository.deleteById(id);
    }
}
