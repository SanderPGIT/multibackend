
package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Bestelling;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BestellingRepository extends CrudRepository <Bestelling, Long> {

}

