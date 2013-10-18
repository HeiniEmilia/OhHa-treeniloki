/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;
/**
 *
 * @author Heini
 */
public class LuoUusiTreenilokiKuuntelija implements ActionListener{
    private JTextField lokinNimi;
    private JTextField kayttajatunnus;
    private JPasswordField salasana;
    private JPasswordField salasana2;
    private JFrame frameKirjaudu;
    private JFrame frame;
    private JFrame frameMuokkaa;
    private TreenilokiTietokanta treenilokit;
    private Treeniloki treeniloki;
    private JLabel teksti;
    
    
    public LuoUusiTreenilokiKuuntelija(JFrame frame, JFrame frameKirjaudu, JTextField nimi, JTextField kayttajatunnus, JPasswordField salasana, JPasswordField salasana2, JLabel salasanatSamat, TreenilokiTietokanta treenilokit){
        this.frameKirjaudu =frameKirjaudu;
        this.frame = frame;
        this.lokinNimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
        this.salasana2=salasana2;
        this.teksti = salasanatSamat;
        this.treenilokit = treenilokit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(salasana.getText().equals(salasana2.getText())){
            this.treeniloki = treenilokit.lisaaTreeniloki(lokinNimi.getText(), kayttajatunnus.getText(), salasana.getText());
            frame.dispose();
            frameKirjaudu.dispose();
        } else {
            teksti.setForeground(Color.red);
            teksti.setText("Salasanat eivät olleet samat!");
        }
        
        frameMuokkaa = new JFrame(treeniloki.toString());
        frameMuokkaa.setPreferredSize(new Dimension(500, 400));
        frameMuokkaa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frameMuokkaa.getContentPane());
        
        frameMuokkaa.pack(); 
        frameMuokkaa.setVisible(true);
        
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(7,1);
        container.setLayout(layout);
        
        JButton lisaaUrheilulaji = new JButton("Lisää urheilulaji");
        lisaaUrheilulaji.addActionListener(new LisaaUrheilulajiKuuntelija(treeniloki));
        JButton lisaaTreeni = new JButton ("Lisää treeni");
        lisaaTreeni.addActionListener(new LisaaTreeniKuuntelija(treeniloki));
        JButton arvoTreeni = new JButton("Arvo treeni");
        arvoTreeni.addActionListener(new ArvoTreeniKuuntelija(treeniloki));
        JButton naytaKooste = new JButton("Näytä kooste");
        naytaKooste.addActionListener(new NaytaKoosteKuuntelija(treeniloki));
        JButton naytaGraafinenKooste = new JButton("Näytä kooste graafisesti");
        naytaGraafinenKooste.addActionListener(new NaytaGraafinenKoosteKuuntelija(treeniloki));
        JButton muokkaaKayttajatietoja = new JButton("Muokkaa käyttäjätietoja");
        muokkaaKayttajatietoja.addActionListener(new VaihdaKayttajatunnusKuuntelija(treeniloki));
        JButton poistu = new JButton("Poistu");
        poistu.addActionListener(new PoistuKuuntelija(frameMuokkaa));
        
        container.add(lisaaUrheilulaji);
        container.add(lisaaTreeni);
        container.add(arvoTreeni);
        container.add(naytaKooste);
        container.add(naytaGraafinenKooste);
        container.add(muokkaaKayttajatietoja);
        container.add(poistu);
    }
    
}
