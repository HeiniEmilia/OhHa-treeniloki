/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.*;

/**
 *
 * @author Heini
 */
public class TiedostostaLukija {
    
    private FileInputStream fileSisaan;
    private ObjectInputStream sisaan;
    
    public TiedostostaLukija() throws Exception{
        this.fileSisaan = new FileInputStream("treeniloki.ser");
        this.sisaan = new ObjectInputStream(fileSisaan);
    }
    
    public Treeniloki palautaTiedostosta()throws Exception{
        return (Treeniloki)sisaan.readObject();
    }
    
}
