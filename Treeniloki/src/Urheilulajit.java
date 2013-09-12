
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heini
 */
public class Urheilulajit {
    private ArrayList<Urheilulaji> urheilulajit;
    
    public Urheilulajit(){
        this.urheilulajit = new ArrayList<Urheilulaji>();
    }
    
    public void lisaaUrheilulaji(Urheilulaji urheilulaji){
        this.urheilulajit.add(urheilulaji);
    }
    
    public void tulostaLajit(){
        for(Urheilulaji urheilulaji : urheilulajit){
            System.out.println(urheilulaji);
        }
    }
    
    public Urheilulaji enitenTreenattu(){
        Urheilulaji eniten = new Urheilulaji("apu");
        if(urheilulajit.isEmpty()){
            System.out.println("Treenilokisi ei sisällä yhtään urheilulajia");
            return null;
        } else{
            for(Urheilulaji urheilulaji : urheilulajit){
                if (urheilulaji.suurempiAika(eniten)){
                    eniten = urheilulaji;
                }
            }
            return eniten;
        }
    }
    
    
}
