/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Heini
 */
public class TreeninArpoja implements Serializable{
    private Random treeniArpa;
    private Random aikaArpa;
    private Treeniloki treeniloki;
    
    public TreeninArpoja(){
        this.treeniArpa = new Random();
        this.aikaArpa = new Random();
    }
    
    public Urheilulaji arvoLaji(ArrayList<Urheilulaji> urheilulajit){
        int lajiaVastaavaLuku = this.treeniArpa.nextInt(treeniloki.urheilulajienMaara()-1);
        Urheilulaji arvottuLaji = urheilulajit.get(lajiaVastaavaLuku);
        return arvottuLaji;
    }
    
    public int arvoAika(int minimiAikaTunnit,int minimiAikaMinuutit, int maksimiAikaTunnit, int maksimiAikaMinuutit){
        int minimiAikaMinuuteissa = 60*minimiAikaTunnit + minimiAikaMinuutit;
        int maksimiAikaMinuuteissa = 60*maksimiAikaTunnit + maksimiAikaMinuutit;
        int arpomisVali = maksimiAikaMinuuteissa-minimiAikaMinuuteissa;
        int arvottuAikaMinuuteissa = this.aikaArpa.nextInt(arpomisVali)+ minimiAikaMinuuteissa;
        return arvottuAikaMinuuteissa;
    }
}
