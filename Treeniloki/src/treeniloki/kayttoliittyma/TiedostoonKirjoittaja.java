/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.io.*;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class TiedostoonKirjoittaja {
    
    private FileOutputStream fileUlos;
    private ObjectOutputStream ulos;
    
    public TiedostoonKirjoittaja() throws Exception{
        fileUlos = new FileOutputStream("treeniloki.ser");
        ulos = new ObjectOutputStream(fileUlos);
        
    }
    
    public void tallennaTiedostoon(TreenilokiTietokanta treenilokit){
        try{
            ulos.reset();
            ulos.writeObject(treenilokit);
            ulos.flush();
            ulos.close();
            fileUlos.close();
        }catch(IOException e){
            System.out.print("Ei tallennettavia treenilokeja");
        }
    }
    
}
