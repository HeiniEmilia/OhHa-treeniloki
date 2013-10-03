/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.Serializable;

/**
 *
 * @author Heini
 */
public class Kayttaja implements Serializable{
    private String kayttajatunnus;
    private String salasana;
    
    /**
     * Luokan Kayttaja konstruktori, joka luo uuden Kayttaja-olion.
     * 
     * @param kayttajatunnus käyttäjätunnus asetetaan luodun olion käyttäjätunnukseksi
     * @param salasana salasana asetetaan luodun olion salasanaksi
     */
    public Kayttaja(String kayttajatunnus, String salasana){
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }
    
    /**
     * Metodi tarkistaa vastaavatko syötetty käyttäjätunnus ja salasana käyttäjälle
     * kuuluvia käyttäjätunnusta ja salasanaa.
     * 
     * @param kayttajatunnus käyttäjätunnus jota verrataan käyttäjän käyttäjätunnukseen
     * @param salasana salasana jota verrataan käyttäjän salasanaan
     * 
     * @return true, jos annettu käyttäjätunnus ja salasana ovat oikein, 
     * false, jos käyttäjätunnus tai salasana tai molemmat olivat väärin.
     */
    public boolean tunnistautuminenOnnistui(String kayttajatunnus, String salasana){
        if(this.kayttajatunnus.equals(kayttajatunnus)&& this.salasana.equals(salasana)){
            return true;
        }
        return false;
    }
    
    public void vaihdaSalasana(String nykyinenKayttajatunnus, String nykyinenSalasana, String uusiSalasana){
        if(tunnistautuminenOnnistui(nykyinenKayttajatunnus,nykyinenSalasana)){
            this.salasana = uusiSalasana;
        }
    }
    
    public void vaihdaKayttajatunnus(String nykyinenKayttajatunnus, String nykyinenSalasana,String uusiKayttajatunnus){
        if(tunnistautuminenOnnistui(nykyinenKayttajatunnus,nykyinenSalasana)){
            this.kayttajatunnus = uusiKayttajatunnus;
        }
    }
    
    public String getKayttajatunnus(){
        return this.kayttajatunnus;
    }
    
    public String getSalasana(){
        return this.salasana;
    }
    
}
