/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import sovelluslogiikka.Treeniloki;
import sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class KirjauduKuuntelija implements ActionListener{
    private JFrame frame;
    private JList lista;
    private TreenilokiTietokanta treenilokit;
    
    public KirjauduKuuntelija(JList lista, TreenilokiTietokanta treenilokit){
        this.frame = new JFrame();
        frame.setPreferredSize(new Dimension(300, 200));
        this.lista = lista;
        this.treenilokit = treenilokit;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = lista.getSelectedIndex();
        Treeniloki treeniloki = treenilokit.getTreenilokit().get(index);
        
        luoKirjautuminenKomponentit(frame.getContentPane(), treeniloki);   
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKirjautuminenKomponentit(Container container, Treeniloki treeniloki){
        GridLayout layout = new GridLayout(3,2);
        container.setLayout(layout);
        
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JTextField salasanaKentta = new JTextField();
        
        JButton kirjauduNappi = new JButton ("Kirjaudu!");
        kirjauduNappi.addActionListener(new OnnistuukoKirjautuminenKuuntelija(treeniloki, frame, kayttajatunnusKentta, salasanaKentta));
        
        container.add(kayttajatunnus);
        container.add(kayttajatunnusKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(new JLabel(""));
        container.add(kirjauduNappi);
        
    }
    
}
