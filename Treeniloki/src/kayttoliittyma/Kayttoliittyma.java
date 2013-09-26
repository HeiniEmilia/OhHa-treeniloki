/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Heini
 */
public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    
    public Kayttoliittyma(){
    }
    
    @Override
    public void run(){
        frame = new JFrame("Treeniloki");
        frame.setPreferredSize(new Dimension(400, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoAloitusKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoAloitusKomponentit(Container container){
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);
        
        JButton tarkasteleNappi = new JButton("Tarkastele treenilokia");
        JButton luoUusiNappi = new JButton("Luo uusi treeniloki");
        luoUusiNappi.addActionListener(new ValitseLuoUusiKuuntelija());
        
        container.add(tarkasteleNappi);
        container.add(luoUusiNappi);
        
    }
    
}
