package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Klant;
import com.doorloop.zwolle.persistence.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KlantEndpoint {
    @Autowired
    KlantService klantService;

    @GetMapping("/klant/plaats/{woonplaats}")
    public List<Klant> findByWoonplaats (@PathVariable String woonplaats){return klantService.findByWoonplaats(woonplaats);}

    @GetMapping("/klant")
    public Iterable<Klant> geefKlanten(){ return klantService.geefMeAlleKlanten();}

    @GetMapping("/klant/{id}")
    public Optional<Klant> geefklantmetid(@PathVariable Long id) { return klantService.geefklant(id); }

    @PostMapping("/klant")
    public Klant extraklant(@RequestBody Klant klant){
        System.out.println(klant.getWoonplaats());
        System.out.println("we zijn in de endpoint");
       return klantService.saveklant(klant);
    }

    @DeleteMapping("/klant/{id}")
    public void remove(@PathVariable Long id){ klantService.remove(id);}

    @PutMapping ("/klant")
    public Klant changeklant(@RequestBody Klant klant){
        return klantService.saveklant(klant);

    }

}
