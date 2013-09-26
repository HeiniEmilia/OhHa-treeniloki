/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.*;
import java.util.*;

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
    
    public void tallennaTiedostoon(Treeniloki treeniloki) throws Exception{
        ulos.writeObject(treeniloki);
        ulos.close();
        fileUlos.close();
    }
    
}
