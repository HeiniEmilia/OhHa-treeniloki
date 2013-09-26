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
    
    public Kayttaja(String kayttajatunnus, String salasana){
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }
    
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
