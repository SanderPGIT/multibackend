package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Bestelling;
import com.doorloop.zwolle.persistence.VerkoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderEndpoint {
    @Autowired
    VerkoopService verkoopService;

    @GetMapping("/bestelling")
    public Iterable<Bestelling> geefbestellingen(){
        return verkoopService.geefMeAlleBestellingen();
    }

    @GetMapping("/bestelling/{id}")
    public Optional<Bestelling> geefbestelling(@PathVariable long id){ return verkoopService.geefbestelling(id);}

    @GetMapping("/bestelling/klant/{id}")
    public List<Bestelling> geefklantbestelling(@PathVariable long id){ return verkoopService.searchKlantbestelling(id);}

    @PostMapping("/bestelling")
    public Bestelling extrabestelling(@RequestBody Bestelling bestelling){
        return verkoopService.saveBestelling(bestelling);
    }

    @DeleteMapping("/bestelling/{id}")
    public void bestellingweg(@PathVariable long id){ verkoopService.removeBestelling(id);
    }

    @PutMapping("/bestelling")
    public Bestelling bestellingchange(@RequestBody Bestelling bestelling){
        verkoopService.save(bestelling);
        return bestelling;
    }

}

