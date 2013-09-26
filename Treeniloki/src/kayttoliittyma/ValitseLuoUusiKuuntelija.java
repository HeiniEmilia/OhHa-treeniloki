/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Heini
 */
public class ValitseLuoUusiKuuntelija implements ActionListener{
    private JFrame frame;
    
    public ValitseLuoUusiKuuntelija(){
        this.frame = new JFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        luoLuoUusiTreenilokiKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoLuoUusiTreenilokiKomponentit(Container container){
        GridLayout layout = new GridLayout(4,2);
        container.setLayout(layout);
        
        JLabel treenilokinNimi = new JLabel("Treenilokin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JTextField salasanaKentta = new JTextField();
        
        JButton luoUusiNappi = new JButton("Luo uusi treeniloki");
        luoUusiNappi.addActionListener(new LuoUusiKuuntelija(frame, nimiKentta, kayttajatunnusKentta, salasanaKentta));
        
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
