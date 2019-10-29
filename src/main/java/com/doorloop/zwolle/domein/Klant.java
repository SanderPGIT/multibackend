package com.doorloop.zwolle.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long klantid;

    private String naam;
    private String adres;
    private String postcode;
    private String woonplaats;

    public long getKlantid() {
        return klantid;
    }

    public void setKlantid(long klantid) {
        this.klantid = klantid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}

