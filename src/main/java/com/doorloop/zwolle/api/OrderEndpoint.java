package com.doorloop.zwolle.api;

import com.doorloop.zwolle.domein.Bestelling;
import com.doorloop.zwolle.persistence.VerkoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderEndpoint {
    @Autowired
    VerkoopService verkoopService;

    @GetMapping("/bestelling")
    public Iterable<Bestelling> geefbestellingen(){
        return verkoopService.geefMeAlleBestellingen();
    }

    @PostMapping("/bestelling/{bestellingid}/{productid}")
    public Bestelling extrabestelling(@RequestBody Bestelling bestelling,@PathVariable("bestellingid") long bestellingid, @PathVariable("productid") long productid){
        return verkoopService.saveBestelling(bestelling);
    }
}

