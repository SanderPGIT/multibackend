

package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Bestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VerkoopService {
    @Autowired
    KlantRepository klantRepository;

    @Autowired
    BestellingRepository bestellingRepository;

    @Autowired
    ProductRepository productRepository;

    public Iterable<Bestelling> geefMeAlleBestellingen(){
        return bestellingRepository.findAll();
    }

    public Optional<Bestelling> geefbestelling(Long id) { return bestellingRepository.findById(id);}

    public Bestelling saveBestelling(Bestelling bestelling){
        //System.out.println(bestelling.getProducts().size());
        for(int i=0; i<bestelling.getProducts().size(); i++ ){
            if ( bestelling.getProducts().get(i).getStock() < bestelling.getAantal()) {
                bestelling.removeProduct(bestelling.getProducts().get(i));
                i--;
            }else{
                bestelling.getProducts().get(i).setStock(bestelling.getProducts().get(i).getStock() - bestelling.getAantal());
                productRepository.save(bestelling.getProducts().get(i));
            }
        }
        return bestellingRepository.save(bestelling);
    }

    public void removeBestelling(Long id) {
        Iterable<Bestelling> bestellingen = bestellingRepository.findAll();
        for(Bestelling bestelling:bestellingen){
            if(bestelling.getId()==id) {
                for (int i = 0; i < bestelling.getProducts().size(); i++) {
                    bestelling.getProducts().get(i).setStock(bestelling.getProducts().get(i).getStock() + bestelling.getAantal());
                    productRepository.save(bestelling.getProducts().get(i));
                }
            }
        }
        bestellingRepository.deleteById(id);
    }

    public Bestelling save(Bestelling bestelling){
        Iterable<Bestelling> bestellingen = bestellingRepository.findAll();
        for(Bestelling bestellinguitrepo:bestellingen){
            if(bestellinguitrepo.getId()==bestelling.getId()){  //zoek in repo oude bestelling die wordt vervangen
                for(int i=0; i<bestelling.getProducts().size(); i++ ) { //loop door producten in nieuwe bestelling
                    if (bestellinguitrepo.getProducts().contains(bestelling.getProducts().get(i))) { //als oude bestelling producten bevat uit nieuwe bestelling
                        for (int j = 0; j < bestellinguitrepo.getProducts().size(); j++) { //loop door producten in oude bestelling
                            System.out.println(bestelling.getProducts().get(i).getId());
                            System.out.println(bestellinguitrepo.getProducts().get(j).getId());
                            if (bestelling.getProducts().get(i).getId() == bestellinguitrepo.getProducts().get(j).getId()) { //als product uit oude bestelling gelijk is aan product nieuw bestelling
                                if ((bestellinguitrepo.getProducts().get(j).getStock() + (bestellinguitrepo.getAantal() - bestelling.getAantal())) < 0) { //check of optionele nieuwe aantal leverbaar is
                                    System.out.println("product op dit moment niet leverbaar in deze nieuwe hoeveelheid");
                                } else { // verander de voorraad van het product
                                    System.out.println("nieuw stock" + (bestelling.getProducts().get(i).getStock() + (bestellinguitrepo.getAantal() - bestelling.getAantal())));
                                    bestelling.getProducts().get(i).setStock(bestelling.getProducts().get(i).getStock() + (bestellinguitrepo.getAantal() - bestelling.getAantal()));
                                    System.out.println(bestelling.getProducts().get(i).getStock());
                                    productRepository.save(bestelling.getProducts().get(i));
                                    System.out.println("voorraad aangepast van gelijke product");
                                }
                            }
                        }
                    } else {// als product uit nieuwe bestelling niet voorkomt in oude bestelling
                        if(bestelling.getProducts().get(i).getStock()<bestelling.getAantal()) {
                            System.out.println("product out of stock, reduce amount or choose other product");
                            bestelling.removeProduct(bestelling.getProducts().get(i));
                            i--;
                        }else{
                            bestelling.getProducts().get(i).setStock(bestelling.getProducts().get(i).getStock()-bestelling.getAantal());
                            productRepository.save(bestelling.getProducts().get(i));
                        }
                    }
                }
                for(int k=0; k<bestellinguitrepo.getProducts().size(); k++ ) { //loop door producten in oude bestelling
                    if (!bestelling.getProducts().contains(bestellinguitrepo.getProducts().get(k))) { //als nieuwe bestelling product heeft dat niet voorkomt in oude
                        bestellinguitrepo.getProducts().get(k).setStock(bestellinguitrepo.getProducts().get(k).getStock() + bestellinguitrepo.getAantal());
                        productRepository.save(bestellinguitrepo.getProducts().get(k));
                    }
                }
            }
        }
        return bestellingRepository.save(bestelling);
    }

    public List<Bestelling> searchKlantbestelling(Long klantid) {
        List<Bestelling> gevondenBestelling = new ArrayList<>();
        Iterable<Bestelling> bestellingen = bestellingRepository.findAll();
        for (Bestelling bestellinguitrepo : bestellingen) {
            if (bestellinguitrepo.getDeklant().getKlantid() == klantid) {
                gevondenBestelling.add(bestellinguitrepo);
            }
        }
        return gevondenBestelling;
    }
}


