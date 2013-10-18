/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import treeniloki.sovelluslogiikka.Kayttaja;
import treeniloki.sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class MuutoksetKayttajanTietoihinKuuntelija implements ActionListener{
    private JTextField kayttis;
    private JPasswordField salasana;
    private JPasswordField salasanaUusiksi;
    private JFrame frame;
    private Kayttaja omistaja;

    public MuutoksetKayttajanTietoihinKuuntelija(Treeniloki treeniloki, JTextField kayttis, JPasswordField salasana, JPasswordField salasanaUudestaan, JFrame frame) {
        this.omistaja = treeniloki.getKayttaja();
        this.kayttis = kayttis;
        this.salasana = salasana;
        this.salasanaUusiksi = salasanaUudestaan;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(salasana.getText().equals(salasanaUusiksi.getText()) && !salasana.getText().isEmpty()){
            omistaja.vaihdaSalasana(salasana.getText());
        } 
        if(!kayttis.getText().equals(omistaja.getKayttajatunnus())){
            omistaja.vaihdaKayttajatunnus(kayttis.getText());
        }
        frame.dispose();
        
    }
    
}
