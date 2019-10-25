package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Supplier;
import com.doorloop.zwolle.domein.SupplyOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SupplyOrderRepository extends CrudRepository<SupplyOrder, Long> {
}
