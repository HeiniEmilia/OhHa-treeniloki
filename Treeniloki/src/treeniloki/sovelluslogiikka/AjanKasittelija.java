/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.sovelluslogiikka;

import java.io.Serializable;

/**
 *
 * @author Heini
 */
public class AjanKasittelija implements Serializable{
    
    public AjanKasittelija(){
        
    }
    
    public String naytaTunteinaJaMinuutteina(int tunnit, int minuutit){
        if(minuutit>9){
            return tunnit + ":" + minuutit;
        }
        return tunnit + ":0" + minuutit;
    }

    public String naytaTunteinaJaMinuutteina(int minuutit){
        if (minuutit<10){
            return "0:0" + minuutit;
        } else if (minuutit<60){
            return "0:" + minuutit;
        } else {
            int tunnit = minuutit/60;
            int minuutitYli = minuutit-(60*tunnit);
            if(minuutitYli<10){
                return tunnit + ":0" + minuutitYli;
            }
            return tunnit + ":" + minuutitYli;
        }
    }
    
}
