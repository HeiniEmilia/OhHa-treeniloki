/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import sovelluslogiikka.Treeniloki;
/**
 *
 * @author Heini
 */
public class LuoUusiKuuntelija implements ActionListener{
    private JTextField lokinNimi;
    private JTextField kayttajatunnus;
    private JTextField salasana;
    private JFrame frame;
    
    public LuoUusiKuuntelija(JFrame frame, JTextField nimi, JTextField kayttajatunnus, JTextField salasana){
        this.frame = frame;
        this.lokinNimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Treeniloki uusiLoki = new Treeniloki(lokinNimi.getText(), kayttajatunnus.getText(), salasana.getText());
        frame.dispose();
    }
    
    
}
