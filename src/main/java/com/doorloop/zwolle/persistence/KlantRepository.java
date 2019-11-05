package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Klant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KlantRepository extends CrudRepository<Klant, Long> {
    List<Klant> findByWoonplaats(String woonplaats);
}
