package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KlantService {
    @Autowired
    KlantRepository klantRepository;

    public Iterable<Klant> geefMeAlleKlanten(){ return klantRepository.findAll(); }

    public Optional<Klant> geefklant(Long id) { return klantRepository.findById(id); }

    public Klant saveklant(Klant klant) {
        System.out.println("we zijn in de service");
        return klantRepository.save(klant);}

    public void remove(Long id) { klantRepository.deleteById(id); }


}
