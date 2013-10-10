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
public class UusiTreenilokiKuuntelija implements ActionListener{
    private JFrame frame;
    private JFrame frameKirjaudu;
    private TreenilokiTietokanta treenilokit;
    
    public UusiTreenilokiKuuntelija(JFrame frame, TreenilokiTietokanta treenilokit){
        this.frame = frame;
        this.frameKirjaudu = new JFrame("Luo Uusi");
        frameKirjaudu.setPreferredSize(new Dimension(300, 200));
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
        GridLayout layout = new GridLayout(4,2);
        container.setLayout(layout);
        
        JLabel treenilokinNimi = new JLabel("Treenilokin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JPasswordField salasanaKentta = new JPasswordField();
        
        JButton luoUusiNappi = new JButton("Luo uusi treeniloki");
        luoUusiNappi.addActionListener(new LuoUusiTreenilokiKuuntelija(frame, frameKirjaudu, nimiKentta, kayttajatunnusKentta, salasanaKentta, treenilokit));
        
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
