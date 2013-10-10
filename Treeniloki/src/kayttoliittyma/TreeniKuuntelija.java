/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import sovelluslogiikka.Treeniloki;
import sovelluslogiikka.Urheilulaji;

/**
 *
 * @author Heini
 */
public class TreeniKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JList lista;
    private JFormattedTextField tunnit;
    private JFormattedTextField minuutit;
    private JFrame frame;
    
    public TreeniKuuntelija(JFrame frame, Treeniloki treeniloki, JList lista, JFormattedTextField tunnit, JFormattedTextField minuutit){
        this.frame = frame;
        this.treeniloki = treeniloki;
        this.lista = lista;
        this.tunnit = tunnit;
        this.minuutit = minuutit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = lista.getSelectedIndex();
        Urheilulaji urheilulaji = treeniloki.getUrheilulajit().get(index);    
        int tunnitNumeroina = (Integer)tunnit.getValue();
        int minuutitNumeroina = (Integer)minuutit.getValue();
        urheilulaji.lisaaAika(tunnitNumeroina, minuutitNumeroina);
        
        frame.dispose();
    }
    
}
