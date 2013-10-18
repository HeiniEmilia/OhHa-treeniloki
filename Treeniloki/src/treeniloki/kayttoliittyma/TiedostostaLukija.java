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
public class TiedostostaLukija {
    
    private FileInputStream fileSisaan;
    private ObjectInputStream sisaan;
    
    public TiedostostaLukija()throws Exception{
        this.fileSisaan = new FileInputStream("treeniloki.ser");
        this.sisaan = new ObjectInputStream(fileSisaan);
    }
    
    public TreenilokiTietokanta palautaTiedostosta(){
        try{
            TreenilokiTietokanta treenilokit = (TreenilokiTietokanta)sisaan.readObject();
            sisaan.close();
            fileSisaan.close();
            return treenilokit;
        } catch (IOException e){
            System.out.println("Tiedosto saavutti lopun");
        } catch (ClassNotFoundException e){
            System.out.println("Ei löytänyt treenilokeja");
        } return new TreenilokiTietokanta();
    }
    
}
