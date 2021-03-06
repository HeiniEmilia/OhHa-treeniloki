/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class KirjauduKuuntelija implements ActionListener{
    private JFrame frame;
    private JFrame frameKirjaudu;
    private JList lista;
    private TreenilokiTietokanta treenilokit;
    
    public KirjauduKuuntelija(JFrame frame, JList lista, TreenilokiTietokanta treenilokit){
        this.frame = frame;
        this.frameKirjaudu = new JFrame();
        frameKirjaudu.setPreferredSize(new Dimension(300, 200));
        this.lista = lista;
        this.treenilokit = treenilokit;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = lista.getSelectedIndex();
        if(index == -1){
            System.out.println("Valitse jokin Treeniloki!");
        }
        Treeniloki treeniloki = treenilokit.getTreenilokit().get(index);
        
        luoKirjautuminenKomponentit(frameKirjaudu.getContentPane(), treeniloki);   
        
        frameKirjaudu.repaint();
        frameKirjaudu.pack();
        frameKirjaudu.setVisible(true);
    }
    
    public void luoKirjautuminenKomponentit(Container container, Treeniloki treeniloki){
        GridLayout layout = new GridLayout(3,2);
        container.setLayout(layout);
        
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JPasswordField salasanaKentta = new JPasswordField();
        
        JLabel vapaaTila = new JLabel("", JLabel.CENTER);
        JButton kirjauduNappi = new JButton ("Kirjaudu!");
        kirjauduNappi.addActionListener(new OnnistuukoKirjautuminenKuuntelija(frame, treeniloki, frameKirjaudu, kayttajatunnusKentta, salasanaKentta, vapaaTila));
        
        container.add(kayttajatunnus);
        container.add(kayttajatunnusKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(vapaaTila);
        container.add(kirjauduNappi);
        
    }
    
}
