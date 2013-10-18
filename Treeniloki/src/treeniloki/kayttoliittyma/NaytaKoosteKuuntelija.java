/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.Urheilulaji;

/**
 *
 * @author Heini
 */
public class NaytaKoosteKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frame;
    
    public NaytaKoosteKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.frame = new JFrame("Treeniloki");
        frame.setPreferredSize(new Dimension(300, 200));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
       
    }
    
    public void luoKomponentit(Container container){
        ArrayList<Urheilulaji> urheilulajit = treeniloki.getUrheilulajit();
        JList urheilulajiLista = new JList(urheilulajit.toArray());
        urheilulajiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        urheilulajiLista.setLayoutOrientation(JList.VERTICAL);
        
        JScrollPane skrolleri = new JScrollPane(urheilulajiLista);
        skrolleri.setPreferredSize(new Dimension(300,200));
        
        container.add(skrolleri);
    }    
}
