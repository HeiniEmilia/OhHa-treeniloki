/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import treeniloki.sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class ArvoTreeniKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frame;
    
   
    public ArvoTreeniKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.frame = new JFrame(treeniloki.toString() + "Arvo Treeni");
        frame.setPreferredSize(new Dimension(300, 200));
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(6,1);
        container.setLayout(layout);
        
        JLabel minimiAika = new JLabel("Treenin minimi aika:");
        
        JFormattedTextField minimiTunnit = new JFormattedTextField(0);
        JLabel minTuntia = new JLabel("tuntia");
        JFormattedTextField minimiMin = new JFormattedTextField(0);
        JLabel minMinuuttia = new JLabel("minuuttia");
        JPanel minimi = new JPanel(new GridLayout(1,4));
        minimi.add(minimiTunnit);
        minimi.add(minTuntia);
        minimi.add(minimiMin);
        minimi.add(minMinuuttia);
        
        
        JLabel maksimiAika = new JLabel("Treenin maksimi aika:");
        
        JFormattedTextField maksimiTunnit = new JFormattedTextField(0);
        JLabel maxTuntia = new JLabel("tuntia");
        JFormattedTextField maksimiMin = new JFormattedTextField(0);
        JLabel maxMinuuttia = new JLabel("minuuttia");
        JPanel maksimi = new JPanel(new GridLayout(1,4));
        maksimi.add(maksimiTunnit);
        maksimi.add(maxTuntia);
        maksimi.add(maksimiMin);
        maksimi.add(maxMinuuttia);
        
        JLabel arvottuTulos = new JLabel("", JLabel.CENTER);
        
        JButton arvoNappi = new JButton("Arvo!");
        arvoNappi.addActionListener(new SuoritaArvontaKuuntelija(treeniloki, minimiTunnit, minimiMin, maksimiTunnit, maksimiMin, arvottuTulos));
        
        
        
        container.add(minimiAika);
        container.add(minimi);
        container.add(maksimiAika);
        container.add(maksimi);
        container.add(arvoNappi);
        container.add(arvottuTulos);
    }
    
}
