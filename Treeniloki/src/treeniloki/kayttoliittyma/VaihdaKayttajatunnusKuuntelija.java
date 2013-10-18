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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import treeniloki.sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class VaihdaKayttajatunnusKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frame;
    
    public VaihdaKayttajatunnusKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame = new JFrame(treeniloki.toString() + ": Muokkaa käyttäjätietoja");
        frame.setPreferredSize(new Dimension(400, 300));
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack(); 
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(4,2);
        container.setLayout(layout);
        
        JLabel kayttis = new JLabel("Käyttäjätunnus");
        JTextField kayttisKentta = new JTextField(treeniloki.getKayttaja().getKayttajatunnus());
        JLabel salasana = new JLabel ("Uusi salasana:");
        JPasswordField salasanaKentta = new JPasswordField();
        JLabel uusiSalasana = new JLabel ("Uusi salasana uudestaan: ");
        JPasswordField uusiSalasanaKentta = new JPasswordField();
        JLabel tyhja = new JLabel("");
        JButton tallenna = new JButton ("Tallenna!");
        tallenna.addActionListener(new MuutoksetKayttajanTietoihinKuuntelija(treeniloki, kayttisKentta, salasanaKentta, uusiSalasanaKentta, frame));
        
        container.add(kayttis);
        container.add(kayttisKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(uusiSalasana);
        container.add(uusiSalasanaKentta);
        container.add(tyhja);
        container.add(tallenna);
    }
    
}
