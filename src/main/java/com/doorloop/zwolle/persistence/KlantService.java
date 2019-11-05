package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KlantService {
    @Autowired
    KlantRepository klantRepository;

    public List<Klant> findByWoonplaats(String plaats) {
        List<Klant> klanten = new ArrayList<>();
        klantRepository.findByWoonplaats(plaats).forEach(klant -> {
            klanten.add(klant);
        });
        return klanten;
    }

    public Iterable<Klant> geefMeAlleKlanten(){ return klantRepository.findAll(); }

    public Optional<Klant> geefklant(Long id) { return klantRepository.findById(id); }

    public Klant saveklant(Klant klant) {
        System.out.println("we zijn in de service");
        return klantRepository.save(klant);}

    public void remove(Long id) { klantRepository.deleteById(id); }


}
