/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.sovelluslogiikka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * TreeninArpoja-luokka
 *
 * @author Heini
 */
public class TreeninArpoja implements Serializable{
    private Random arpoja;
    
    /**
     * Luokan TreeninArpoja konstruktori, joka luo uuden TreeninArpoja-olion. 
     * Kullakin TreeninArpoja-oliolla on oma Random-olio, joka suorittaa arpomisen.
     */
    public TreeninArpoja(){
        this.arpoja = new Random();
    }
    
    /**
     * Metodi arpoo luvun väliltä 0 ja urheilulaji-listan koon väliltä ja 
     * hakee sen jälkeen listasta numeroa vastaavalla paikalla olevan urheilulajin.
     * 
     * @param urheilulajit Lista, josta Urheilulaji arvotaan
     * 
     * @return Urheilulaji, joka arpomalla saatiin
     */
    public Urheilulaji arvoLaji(ArrayList<Urheilulaji> urheilulajit){
        int lajiaVastaavaLuku = this.arpoja.nextInt(urheilulajit.size());
        Urheilulaji arvottuLaji = urheilulajit.get(lajiaVastaavaLuku);
        return arvottuLaji;
    }
    
    /**
     * Metodi arpoo luvun ajan alarajan ja ylärajan väliltä minuuteissa.
     * 
     * @param minimiAikaTunnit ajan alarajan tuntien osuus
     * @param minimiAikaMinuutit ajan alarajan minuuttien osuus
     * @param maksimiAikaTunnit ajan ylärajan tuntien osuus
     * @param maksimiAikaMinuutit ajan ylärajan minuuttien osuus
     * 
     * @return palauttaa arvotun ajan minuuteissa
     */
    public int arvoAika(int minimiAikaTunnit, int minimiAikaMinuutit, int maksimiAikaTunnit, int maksimiAikaMinuutit){
        int minimiAikaMinuuteissa = 60*minimiAikaTunnit + minimiAikaMinuutit;
        int maksimiAikaMinuuteissa = 60*maksimiAikaTunnit + maksimiAikaMinuutit;
        int arpomisVali = maksimiAikaMinuuteissa-minimiAikaMinuuteissa;
        int arvottuAikaMinuuteissa = this.arpoja.nextInt(arpomisVali) + minimiAikaMinuuteissa;
        return arvottuAikaMinuuteissa;
    }
}
