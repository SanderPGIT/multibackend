package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Supplier;
import com.doorloop.zwolle.domein.SupplyOrder;
import com.doorloop.zwolle.persistence.SupplyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplyOrderEndpoint {
    @Autowired
    SupplyOrderService supplyOrderService;

    @GetMapping("/supplyOrder")
    public Iterable<SupplyOrder>geefSupplierOrders(){
        return supplyOrderService.geefOrders();
    }

    @PostMapping("/supplyOrder/{supplierId}/product")
    public SupplyOrder newOrder(@RequestBody SupplyOrder supplyOrder, @PathVariable long supplierId, @RequestParam long productId){
        SupplyOrder result = supplyOrderService.addOrder(supplyOrder, supplierId, productId);
        return result;
    }

    @DeleteMapping("/supplyOrder/{id}")
    public void delOrder(@PathVariable long id){
        supplyOrderService.delOrder(id);
    }

    @PutMapping("/supplyOrder/{supplierId}/{productId}")
    public SupplyOrder pasOrderAan(@RequestBody SupplyOrder supplyOrder, @PathVariable long supplierId, @PathVariable long productId){
        SupplyOrder result = supplyOrderService.addOrder(supplyOrder, supplierId, productId);
        return result;

    }

}