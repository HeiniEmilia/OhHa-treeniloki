/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author Heini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
           
        //TiedostoonKirjoittaja tiedostoon = new TiedostoonKirjoittaja();
        //TiedostostaLukija palauta = new TiedostostaLukija();
        
        //TreenilokiTietokanta treenilokit = new TreenilokiTietokanta();
        //treenilokit.lisaaTreeniloki("Treenit 2013", "Testeri", "salasana1");
        //Treeniloki treeniloki1 = new Treeniloki ("Juoksut", "Kayttaja", "salis");
        //tiedostoon.tallennaTiedostoon(treenilokit);

        //Treeniloki treeniloki2;
        //treeniloki2 = palauta.palautaTiedostosta();
        //System.out.println(treeniloki2.haeLokinNimi());
        
        // TODO code application logic here
    }
}
