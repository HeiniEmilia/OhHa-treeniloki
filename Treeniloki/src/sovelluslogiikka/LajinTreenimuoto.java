/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author Heini
 */
public class LajinTreenimuoto {
    private String nimi;
    private int tunnit;
    private int minuutit;
    
    public LajinTreenimuoto(String nimi){
        this.nimi = nimi;
        this.tunnit = 0;
        this.minuutit = 0;
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
    
}
