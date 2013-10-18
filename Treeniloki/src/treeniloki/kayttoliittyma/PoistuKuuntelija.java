/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Heini
 */
public class PoistuKuuntelija implements ActionListener{
    private JFrame frame;
    
    public PoistuKuuntelija(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int result = JOptionPane.showConfirmDialog(
            frame,
            "Haluatko varmasti poistua?",
            "Poistu",
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
}
