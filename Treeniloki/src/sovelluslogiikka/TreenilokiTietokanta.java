/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.ArrayList;

/**
 *
 * @author Heini
 */
public class TreenilokiTietokanta {
    private ArrayList<Treeniloki> treenilokit;
    
    public TreenilokiTietokanta()throws Exception{
        this.treenilokit = new ArrayList<Treeniloki>();
    }
    
    public ArrayList<Treeniloki> getTreenilokit(){
        return this.treenilokit;
    }
    
    public void lisaaTreeniloki(String nimi, String kayttajatunnus, String salasana){
        Treeniloki treeniloki = new Treeniloki(nimi, kayttajatunnus, salasana);
        treenilokit.add(treeniloki);
    }
}
