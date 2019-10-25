package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SupplierRepository extends CrudRepository<Supplier, Long> {

}
