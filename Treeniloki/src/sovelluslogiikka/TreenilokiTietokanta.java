/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Heini
 */
public class TreenilokiTietokanta implements Serializable{
    private ArrayList<Treeniloki> treenilokit;
    
    public TreenilokiTietokanta(){
        this.treenilokit = new ArrayList<Treeniloki>();
    }
    
    public ArrayList<Treeniloki> getTreenilokit(){
        return this.treenilokit;
    }
    
    /**
     * Metodi lisää uuden Treenilokin Treenilokitietokantaan
     * 
     * @param nimi uuden Treenilokin nimi
     * @param kayttajatunnus Treenilokin käyttäjän käyttäjätunnus
     * @param salasana Treenilokin käyttäjän salasana
     * 
     * @see sovelluslogiikka.Treeniloki#Treeniloki(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Treeniloki lisaaTreeniloki(String nimi, String kayttajatunnus, String salasana){
        Treeniloki treeniloki = new Treeniloki(nimi, kayttajatunnus, salasana);
        treenilokit.add(treeniloki);
        return treeniloki;
    }
}
