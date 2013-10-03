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
import javax.swing.JTextField;

/**
 *
 * @author Heini
 */
public class KirjauduKuuntelija implements ActionListener{
    private JFrame frame;
    
    public KirjauduKuuntelija(){
        this.frame = new JFrame();
        frame.setPreferredSize(new Dimension(300, 200));
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        luoKirjautuminenKomponentit(frame.getContentPane());   
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKirjautuminenKomponentit(Container container){
        GridLayout layout = new GridLayout(3,2);
        container.setLayout(layout);
        
        JLabel kayttajatunnus = new JLabel("Kayttajatunnus: ");
        JTextField kayttajatunnusKentta = new JTextField();
        JLabel salasana = new JLabel("Salasana: ");
        JTextField salasanaKentta = new JTextField();
        
        JButton luoUusiNappi = new JButton ("Kirjaudu!");
        
        container.add(kayttajatunnus);
        container.add(kayttajatunnusKentta);
        container.add(salasana);
        container.add(salasanaKentta);
        container.add(new JLabel(""));
        container.add(luoUusiNappi);
        
    }
    
}
