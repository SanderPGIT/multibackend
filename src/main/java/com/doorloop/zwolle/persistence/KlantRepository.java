package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Klant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface KlantRepository extends CrudRepository<Klant, Long> {

}
