/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class UusiTreenilokiKuuntelija implements ActionListener{
    private JFrame frame;
    private JFrame frameKirjaudu;
    private TreenilokiTietokanta treenilokit;
    
    public UusiTreenilokiKuuntelija(JFrame frame, TreenilokiTietokanta treenilokit){
        this.frame = frame;
        this.frameKirjaudu = new JFrame("Luo Uusi");
        frameKirjaudu.setPreferredSize(new Dimension(400, 200));
        frameKirjaudu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.treenilokit = treenilokit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        luoUusiTreenilokiKomponentit(frameKirjaudu.getContentPane());
        
        frameKirjaudu.pack();
        frameKirjaudu.setVisible(true);
    }
    
    public void luoUusiTreenilokiKomponentit(Container container){
        GridLayout layout = new GridLayout(5,2);
        container.setLayout(layout);
        
        JLabel treenilokinNimi = new JLabel("Treenilokin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JPasswordField salasanaKentta = new JPasswordField();
        JLabel salasana2 = new JLabel("Anna salasana uudestaan: ");
        JPasswordField salasanaKentta2 = new JPasswordField();
        JLabel teksti = new JLabel("", JLabel.CENTER);
        
        JButton luoUusiNappi = new JButton("Luo uusi treeniloki");
        luoUusiNappi.addActionListener(new LuoUusiTreenilokiKuuntelija(frame, frameKirjaudu, nimiKentta, kayttajatunnusKentta, salasanaKentta, salasanaKentta2, teksti, treenilokit));
        
        container.add(treenilokinNimi);
        container.add(nimiKentta);
        container.add(kayttajatunnus);
        container.add(kayttajatunnusKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(salasana2);
        container.add(salasanaKentta2);
        container.add(teksti);
        container.add(luoUusiNappi);
    }
   
    
}
