/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.*;
import javax.swing.*;
import sovelluslogiikka.TreenilokiTietokanta;
/**
 *
 * @author Heini
 */
public class LuoUusiKuuntelija implements ActionListener{
    private JTextField lokinNimi;
    private JTextField kayttajatunnus;
    private JTextField salasana;
    private JFrame frame;
    private TreenilokiTietokanta treenilokit;
    
    public LuoUusiKuuntelija(JFrame frame, JTextField nimi, JTextField kayttajatunnus, JTextField salasana, TreenilokiTietokanta treenilokit){
        this.frame = frame;
        this.lokinNimi = nimi;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
        this.treenilokit = treenilokit;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        treenilokit.lisaaTreeniloki(lokinNimi.getText(), kayttajatunnus.getText(), salasana.getText());
        frame.dispose();
    }
    
    
}
