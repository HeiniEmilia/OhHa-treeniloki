package sovelluslogiikka;

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
    
    public Treeniloki(String nimi, String kayttajatunnus, String salasana){
        this.lokinNimi = nimi;
        this.arpoja = new TreeninArpoja();
        this.omistaja = new Kayttaja(kayttajatunnus, salasana);
        this.urheilulajit = new ArrayList<Urheilulaji>();
    }
    
    public String haeLokinNimi(){
        return this.lokinNimi;
    }    
    
    /**
     * Metodi luo uuden urheilulajin ja lisää sen urheilulajit listaan, 
     * joka sisältää kaikki treenilokin urheilulajit.
     * 
     * @param nimi lisättävän urheilulajin nimi
     *
     */
    public void luoUusiUrheilulaji(String nimi){
        this.lajienMaara ++;
        Urheilulaji urheilulaji = new Urheilulaji(nimi);
        urheilulajit.add(urheilulaji);
    }
    
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
    
    public void arvoTreeni(int minTunnit, int minMinuutit, int maxTunnit, int maxMinuutit, ArrayList<Urheilulaji> urheilulajit){
        arpoja.arvoAika(minTunnit, minMinuutit, maxTunnit, maxMinuutit);
        arpoja.arvoLaji(urheilulajit);
    }
    
    @Override
    public String toString(){
        return this.lokinNimi;
    }

}
