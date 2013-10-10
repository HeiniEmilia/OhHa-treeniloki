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
import sovelluslogiikka.Treeniloki;
import sovelluslogiikka.TreenilokiTietokanta;
/**
 *
 * @author Heini
 */
public class LuoUusiTreenilokiKuuntelija implements ActionListener{
    private JTextField lokinNimi;
    private JTextField kayttajatunnus;
    private JPasswordField salasana;
    private JFrame frameKirjaudu;
    private JFrame frame;
    private JFrame frameMuokkaa;
    private TreenilokiTietokanta treenilokit;
    private Treeniloki treeniloki;
    
    public LuoUusiTreenilokiKuuntelija(JFrame frame, JFrame frameKirjaudu, JTextField nimi, JTextField kayttajatunnus, JPasswordField salasana, TreenilokiTietokanta treenilokit){
        this.frameKirjaudu =frameKirjaudu;
        this.frame = frame;
        this.lokinNimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
        this.treenilokit = treenilokit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        this.treeniloki = treenilokit.lisaaTreeniloki(lokinNimi.getText(), kayttajatunnus.getText(), salasana.getText());
        frame.dispose();
        frameKirjaudu.dispose();
        
        frameMuokkaa = new JFrame(treeniloki.toString());
        frameMuokkaa.setPreferredSize(new Dimension(500, 400));
        frameMuokkaa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frameMuokkaa.getContentPane());
        
        frameMuokkaa.pack(); 
        frameMuokkaa.setVisible(true);
        
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(6,1);
        container.setLayout(layout);
        
        JButton lisaaUrheilulaji = new JButton("Lisää urheilulaji");
        lisaaUrheilulaji.addActionListener(new LisaaUrheilulajiKuuntelija(treeniloki));
        JButton lisaaTreeni = new JButton ("Lisää treeni");
        lisaaTreeni.addActionListener(new LisaaTreeniKuuntelija(treeniloki));
        JButton arvoTreeni = new JButton("Arvo treeni");
        arvoTreeni.addActionListener(new ArvoTreeniKuuntelija(treeniloki));
        JButton naytaLajit = new JButton("Näytä urheilulajit");
        
        JButton naytaKooste = new JButton("Näytä kooste");
        JButton naytaGraafinenKooste = new JButton("Näytä kooste graafisesti");
        
        container.add(lisaaUrheilulaji);
        container.add(lisaaTreeni);
        container.add(arvoTreeni);
        container.add(naytaLajit);
        container.add(naytaKooste);
        container.add(naytaGraafinenKooste);
    }
    
}
