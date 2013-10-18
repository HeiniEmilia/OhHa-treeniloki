/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.sovelluslogiikka;

import java.io.Serializable;

/**
 *Kayttaja-luokka.
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
    /**
     * Metodi vaihtaa salasanan uuteen salasanaan.
     * 
     * @param uusiSalasana annetaan uusi salasana
     */
    public void vaihdaSalasana(String uusiSalasana){
            this.salasana = uusiSalasana;
    }
    
    /**
     * Metodi vaihtaa käyttäjätunnuksen uuteen käyttäjätunnukseen
     * 
     * @param uusiKayttajatunnus annetaan uusi kayttajatunnus
     */
    public void vaihdaKayttajatunnus(String uusiKayttajatunnus){
            this.kayttajatunnus = uusiKayttajatunnus;
    }
    
    public String getKayttajatunnus(){
        return this.kayttajatunnus;
    }
    
    public String getSalasana(){
        return this.salasana;
    }
    
}
