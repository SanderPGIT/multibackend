

package com.doorloop.zwolle.persistence;

import com.doorloop.zwolle.domein.Bestelling;
import com.doorloop.zwolle.domein.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VerkoopService {
    @Autowired
    BestellingRepository bestellingRepository;

    @Autowired
    ProductRepository productRepository;

    public Iterable<Bestelling> geefMeAlleBestellingen(){
        return bestellingRepository.findAll();
    }

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
                for(int i=0; i<bestellinguitrepo.getProducts().size(); i++ ){ //loop door producten in oude bestelling
                    for(int j=0; j<bestelling.getProducts().size();j++){ //loop door producten in nieuwe bestelling
                        System.out.println(bestellinguitrepo.getProducts().get(i).getId());
                        System.out.println(bestelling.getProducts().get(j).getId());
                        if(bestellinguitrepo.getProducts().get(i).getId()==bestelling.getProducts().get(j).getId()){ //als product uit oude bestelling gelijk is aan product nieuw bestelling
                            System.out.println("producten matchen");
                            System.out.println("huidige stock" + bestelling.getProducts().get(j).getStock());
                            System.out.println("nieuw aantal" + bestelling.getAantal());
                            System.out.println("oud aantal" + bestellinguitrepo.getAantal());
                            if((bestelling.getProducts().get(j).getStock()+(bestellinguitrepo.getAantal()-bestelling.getAantal()))<0){ //check of optionele nieuwe aantal leverbaar is
                                System.out.println("product op dit moment niet leverbaar in deze nieuwe hoeveelheid");
                            }else{ // verander de voorraad van het product
                                System.out.println("nieuw stock" + (bestelling.getProducts().get(j).getStock()+(bestellinguitrepo.getAantal()-bestelling.getAantal())));
                                bestelling.getProducts().get(j).setStock(bestelling.getProducts().get(j).getStock()+(bestellinguitrepo.getAantal()-bestelling.getAantal()));
                                System.out.println(bestelling.getProducts().get(j).getStock());
                                productRepository.save(bestelling.getProducts().get(j));
                                System.out.println("voorraad aangepast van gelijke product");
                            }
                        }/*else{// als product uit oude bestelling niet voorkomt in nieuwe bestelling of product in nieuwe bestelling niet voorkomt in oude bestelling
                            if(!bestellinguitrepo.getProducts().contains(bestelling.getProducts().get(j))){// als product in nieuwe bestelling niet voorkomt in oude
                                if(bestelling.getProducts().get(j).getStock()<bestelling.getAantal()) {
                                    System.out.println("product out of stock, reduce amount or choose other product");
                                    bestelling.removeProduct(bestelling.getProducts().get(j));
                                    j--;
                                }else{
                                    bestelling.getProducts().get(j).setStock(bestelling.getProducts().get(j).getStock()-bestelling.getAantal());
                                    productRepository.save(bestelling.getProducts().get(j));
                                }
                            }
                            if (!bestelling.getProducts().contains(bestellinguitrepo.getProducts().get(i))){ // als product in oude bestelling niet voorkomt in nieuwe bestelling
                                bestellinguitrepo.getProducts().get(i).setStock(bestellinguitrepo.getProducts().get(i).getStock()+bestellinguitrepo.getAantal());
                                productRepository.save(bestellinguitrepo.getProducts().get(i));
                            }
                        }*/
                    }
                }
            }
        }
        return bestellingRepository.save(bestelling);
    }
}


