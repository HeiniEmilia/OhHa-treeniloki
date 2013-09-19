package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heini
 */
public class Urheilulaji {
    private String nimi;
    private int tunnit;
    private int minuutit;
    private int lajillaEriTreenimuotoja = 0;
    
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
    
    public void lisaaLajilleTreenimuotoja(String treenimuodonNimi){
        LajinTreenimuoto treenimuoto = new LajinTreenimuoto(treenimuodonNimi);
        this.lajillaEriTreenimuotoja ++;
    }
    
    public int treenimuotojenMaara(){
        return this.lajillaEriTreenimuotoja;
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
    
    public String toString(){
        return this.nimi + " "+ this.haeAika();
    }
}
