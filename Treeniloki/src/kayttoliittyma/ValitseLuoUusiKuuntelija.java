/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class ValitseLuoUusiKuuntelija implements ActionListener{
    private JFrame frame;
    private TreenilokiTietokanta treenilokit;
    
    public ValitseLuoUusiKuuntelija(TreenilokiTietokanta treenilokit){
        this.frame = new JFrame();
        frame.setPreferredSize(new Dimension(300, 200));
        this.treenilokit = treenilokit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        luoUusiTreenilokiKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoUusiTreenilokiKomponentit(Container container){
        GridLayout layout = new GridLayout(4,2);
        container.setLayout(layout);
        
        JLabel treenilokinNimi = new JLabel("Treenilokin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JTextField salasanaKentta = new JTextField();
        
        JButton luoUusiNappi = new JButton("Luo uusi treeniloki");
        luoUusiNappi.addActionListener(new LuoUusiKuuntelija(frame, nimiKentta, kayttajatunnusKentta, salasanaKentta, treenilokit));
        
        container.add(treenilokinNimi);
        container.add(nimiKentta);
        container.add(kayttajatunnus);
        container.add(kayttajatunnusKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(new JLabel(""));
        container.add(luoUusiNappi);
    }
   
    
}
