/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class LisaaUrheilulajiKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frameLisaaLaji;
    
    public LisaaUrheilulajiKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.frameLisaaLaji = new JFrame(treeniloki.toString());
        frameLisaaLaji.setPreferredSize(new Dimension(300, 200));
        
        luoKomponentit(frameLisaaLaji.getContentPane());
        
        frameLisaaLaji.repaint();
        frameLisaaLaji.pack();
        frameLisaaLaji.setVisible(true);
        
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(2,2);
        container.setLayout(layout);
        
        JLabel lajinNimi = new JLabel("Urheilulajin nimi: ");
        JTextField lajinNimiKentta = new JTextField();
        
        JButton lisaaNappi = new JButton ("Lisää Urheilulaji!");
        lisaaNappi.addActionListener(new UusiLajiKuuntelija(frameLisaaLaji, treeniloki, lajinNimiKentta));
        
        container.add(lajinNimi);
        container.add(lajinNimiKentta);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }
    
}
