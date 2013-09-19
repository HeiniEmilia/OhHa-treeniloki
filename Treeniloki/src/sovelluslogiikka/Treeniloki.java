package sovelluslogiikka;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heini
 */
public class Treeniloki {
    private TreeninArpoja arpoja;
    private Kayttaja omistaja;
    private int lajienMaara = 0;
    
    public Treeniloki(String kayttajatunnus, String salasana){
        this.arpoja = new TreeninArpoja();
        this.omistaja = new Kayttaja(kayttajatunnus, salasana);
    }
    
    public void luoUusiUrheilulaji(String nimi){
        Urheilulaji uusiUrheilulaji = new Urheilulaji(nimi);
        this.lajienMaara ++;
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
