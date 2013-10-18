package treeniloki.sovelluslogiikka;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Urheilulaji-luokka
 *
 * @author Heini
 */
public class Urheilulaji implements Serializable{
    private String nimi;
    private int tunnit;
    private int minuutit;
    private AjanKasittelija ajankasittelija;
    
    /**
     * Luokan Urheilulaji konstruktori, joka asettaa Urheilulajin nimeksi annetun merkkijonon.
     * 
     * @param nimi merkkijono, joka asetetaan Urheilulajin nimeksi
     */
    public Urheilulaji(String nimi){
        this.nimi = nimi;
        this.tunnit = 0;
        this.minuutit = 0;
        this.ajankasittelija = new AjanKasittelija();
    }
    
    /**
     * Metodi palauttaa urheilulajin ajan merkkijonomuodossa luokan tunnit ja minuutit 
     * parametreissa olevien arvojen perusteella
     * 
     * @return palauttaa merkkijonon muodossa "hh:mm"
     */
    public String haeAika(){
        return ajankasittelija.naytaTunteinaJaMinuutteina(this.tunnit, this.minuutit);
    }
    
    public int aikaMinuuteissa(){
        return this.tunnit*60+this.minuutit;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    /**
     * Metodi lisaa Urheilulajin tunnit ja minuutit attribuutteihin aikaa.
     * 
     * @param lisaaTunnit lisättävien tuntien määrä
     * @param lisaaMinuutit lisättävien minuuttien määrä
     */
    public void lisaaAika(int lisaaTunnit, int lisaaMinuutit){
        int minuutitYhteensa = lisaaMinuutit + this.minuutit;
        if(minuutitYhteensa < 60){
            this.minuutit = minuutitYhteensa;
            this.tunnit = this.tunnit + lisaaTunnit;
        } else {
            int tuntejaMinuuteista = minuutitYhteensa/60;
            int minuutitMinuuteista = lisaaMinuutit - (tuntejaMinuuteista*60);
            this.tunnit = this.tunnit + lisaaTunnit + tuntejaMinuuteista;
            this.minuutit = this.minuutit + minuutitMinuuteista;
        }
    }
    
    @Override
    public String toString(){
        return this.nimi + " "+ this.haeAika();
    }
}
