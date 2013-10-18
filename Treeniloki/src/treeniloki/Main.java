/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki;

import javax.swing.SwingUtilities;
import treeniloki.kayttoliittyma.Kayttoliittyma;
import treeniloki.kayttoliittyma.TiedostostaLukija;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;
import treeniloki.kayttoliittyma.TiedostoonKirjoittaja;

/**
 *
 * @author Heini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //TiedostoonKirjoittaja tiedostoon = new TiedostoonKirjoittaja();
        //TiedostostaLukija palauta = new TiedostostaLukija();
        //final TreenilokiTietokanta treenilokit = palauta.palautaTiedostosta();
        
        //Thread t = new Thread(){
            //@Override
            //public void run(){
              //  tiedostoon.tallennaTiedostoon(treenilokit);
            //}
        //};
        //Runtime.getRuntime().addShutdownHook(t);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        //TreenilokiTietokanta treenilokit = new TreenilokiTietokanta();
        //Treeniloki treeniloki = treenilokit.lisaaTreeniloki("Treenit 2013", "Testeri", "salasana");
        //treeniloki.luoUusiUrheilulaji("Jääkiekko");
        //treeniloki.luoUusiUrheilulaji("Hiihto");
        //treenilokit.lisaaTreeniloki("Heinin Treenit", "HeiniEmilia", "haisuli");
        //String minuutit = treeniloki.arvoTreeni(1, 30, 2, 0, treeniloki.getUrheilulajit());
        
        
        
        //System.out.println("" + minuutit);
        //tiedostoon.tallennaTiedostoon(treenilokit);

        //TreenilokiTietokanta treenilokit2 = new TreenilokiTietokanta(); 
        //treenilokit2 = palauta.palautaTiedostosta();
        //for(Treeniloki treeniloki : treenilokit2.getTreenilokit()){
           //System.out.println(treeniloki.toString());
        //}
        
        
        // TODO code application logic here
    }
}
