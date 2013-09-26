package sovelluslogiikka;

import java.util.ArrayList;
import java.io.*;

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
    
    public Treeniloki(String nimi, String kayttajatunnus, String salasana){
        this.lokinNimi = nimi;
        this.arpoja = new TreeninArpoja();
        this.omistaja = new Kayttaja(kayttajatunnus, salasana);
    }
    
    public String haeLokinNimi(){
        return this.lokinNimi;
    }    
    
    public Urheilulaji luoUusiUrheilulaji(String nimi){
        this.lajienMaara ++;
        return new Urheilulaji(nimi);
    }
    
    public void lisaaTreeni(Urheilulaji urheiltuLaji, int tunnit, int minuutit){
        urheiltuLaji.lisaaAika(tunnit, minuutit);
    }
    
    public int urheilulajienMaara(){
        return this.lajienMaara;
    }
    
    public void arvoTreeni(int minTunnit, int minMinuutit, int maxTunnit, int maxMinuutit){
        arpoja.arvoAika(minTunnit, minMinuutit, maxTunnit, maxMinuutit);
        arpoja.arvoLaji();
    }

}
