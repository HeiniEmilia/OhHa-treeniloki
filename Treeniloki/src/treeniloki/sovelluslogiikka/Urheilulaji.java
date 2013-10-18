package treeniloki.sovelluslogiikka;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heini
 */
public class Urheilulaji implements Serializable{
    private String nimi;
    private int tunnit;
    private int minuutit;
    
    public Urheilulaji(String nimi){
        this.nimi = nimi;
        this.tunnit = 0;
        this.minuutit = 0;
    }
    
    public String haeAika(){
        if(this.minuutit>9){
            return this.tunnit + ":" + this.minuutit;
        }
        return this.tunnit + ":0" + this.minuutit;
    }
    
    public int aikaMinuuteissa(){
        return this.tunnit*60+this.minuutit;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
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
    
    public boolean suurempiAika(Urheilulaji verrattava){
        if (this.tunnit>verrattava.tunnit || (this.tunnit==verrattava.tunnit && this.minuutit>verrattava.minuutit)){
            return true;
        }
        return false;
    }
    
    public boolean samatAjat(Urheilulaji verrattava){
        if(this.tunnit==verrattava.tunnit && this.minuutit==verrattava.minuutit){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.nimi + " "+ this.haeAika();
    }
}
