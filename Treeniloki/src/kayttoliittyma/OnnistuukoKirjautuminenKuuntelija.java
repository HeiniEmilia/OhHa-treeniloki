/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class OnnistuukoKirjautuminenKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frame;
    private JTextField kayttajatunnus;
    private JTextField salasana;
    
    public OnnistuukoKirjautuminenKuuntelija(Treeniloki treeniloki, JFrame frame, JTextField kayttajatunnus, JTextField salasana){
        this.treeniloki = treeniloki;
        this.frame = frame;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(treeniloki.Kirjaudu(this.kayttajatunnus.getText(), this.salasana.getText())){
            frame.dispose();
        } else {
            System.out.println("Syötä uudestaan");
        }
        
    }
    
}
