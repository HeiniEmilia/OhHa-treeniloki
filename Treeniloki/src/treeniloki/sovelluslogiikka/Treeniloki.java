package treeniloki.sovelluslogiikka;

import java.io.*;
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heini
 */
public class Treeniloki implements Serializable{
    private TreeninArpoja arpoja;
    private Kayttaja omistaja;
    private int lajienMaara = 0;
    private String lokinNimi;
    private ArrayList<Urheilulaji> urheilulajit;
    private AjanKasittelija ajankasittelija;
    
    public Treeniloki(String nimi, String kayttajatunnus, String salasana){
        this.lokinNimi = nimi;
        this.arpoja = new TreeninArpoja();
        this.omistaja = new Kayttaja(kayttajatunnus, salasana);
        this.urheilulajit = new ArrayList<Urheilulaji>();
        this.ajankasittelija = new AjanKasittelija();
    }
    
    public Kayttaja getKayttaja(){
        return this.omistaja;
    }
    
    public boolean Kirjaudu(String kayttajatunnus, String salasana){
        if (this.omistaja.tunnistautuminenOnnistui(kayttajatunnus, salasana)){
            return true;
        }
        return false;
    }
    
    /**
     * Metodi luo uuden urheilulajin ja lisää sen urheilulajit listaan, 
     * joka sisältää kaikki treenilokin urheilulajit.
     * 
     * @param nimi lisättävän urheilulajin nimi
     *
     */
    public Urheilulaji luoUusiUrheilulaji(String nimi){
        this.lajienMaara ++;
        Urheilulaji urheilulaji = new Urheilulaji(nimi);
        urheilulajit.add(urheilulaji);
        return urheilulaji;
    }
    
    public ArrayList<Urheilulaji> getUrheilulajit(){
        return this.urheilulajit;
    }
    
    /**
     * Metodi lisää valitulle Urheilulajille aikaa annettujen tuntien ja minuuttien määrän verran.
     * 
     * @param urheiltuLaji laji, johon aikaa lisätään
     * @param tunnit tuntien määrä joka lisätään
     * @param minuutit minuuttien määrä joka lisätään
     * 
     * @see sovelluslogiikka.Urheilulaji#lisaaAika(int, int) 
     */
    public void lisaaTreeni(Urheilulaji urheiltuLaji, int tunnit, int minuutit){
        urheiltuLaji.lisaaAika(tunnit, minuutit);
    }
    
    /**
     * Metodi kertoo kuinka monta urheilulajia treeniloki sisältää.
     * 
     * @return treenilokin sisältämien lajien määrä
     */
    public int urheilulajienMaara(){
        return this.lajienMaara;
    }
    
    /**
     * Metodi arpoo treenin keston annettujen ala-ja ylärajojen väliltä ja 
     * urheiltavan lajin treenilokin sisältämistä urheilulajeista.
     * 
     * @param minTunnit treenin keston alarajan tunnit
     * @param minMinuutit treenin keston alarajan minuutit
     * @param maxTunnit treenin keston ylärajan tunnit
     * @param maxMinuutit treenin keston alarajan minuutit
     * @param urheilulajit lista treenilokin sisältämistä urheilulajeista
     * 
     * @see sovelluslogiikka.TreeninArpoja#arvoAika(int, int, int, int)
     * @see sovelluslogiikka.TreeninArpoja#arvoLaji(java.util.ArrayList) 
     */
    public String arvoTreeni(int minTunnit, int minMinuutit, int maxTunnit, int maxMinuutit, ArrayList<Urheilulaji> urheilulajit){
        int aika = arpoja.arvoAika(minTunnit, minMinuutit, maxTunnit, maxMinuutit);
        String aikaNatisti = ajankasittelija.naytaTunteinaJaMinuutteina(aika);
        Urheilulaji arvottu = arpoja.arvoLaji(urheilulajit);
        
        return arvottu.getNimi() + " - "+ aikaNatisti;
    }
    
    @Override
    public String toString(){
        return this.lokinNimi;
    }

}
