/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import treeniloki.sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class UusiLajiKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JTextField lajinNimi;
    private JFrame frame;
    
    public UusiLajiKuuntelija(JFrame frame, Treeniloki treeniloki, JTextField lajinNimi){
        this.frame = frame;
        this.lajinNimi = lajinNimi;
        this.treeniloki = treeniloki;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        treeniloki.luoUusiUrheilulaji(lajinNimi.getText());
        System.out.println("Uusi urheilulaji lisätty");
        frame.dispose();
    }
    
}
