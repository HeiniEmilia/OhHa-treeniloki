/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import treeniloki.sovelluslogiikka.Treeniloki;

/**
 *
 * @author csguest
 */
public class SuoritaArvontaKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFormattedTextField minH;
    private JFormattedTextField minM;
    private JFormattedTextField maxH;
    private JFormattedTextField maxM;
    private JLabel arvottu;
    
    public SuoritaArvontaKuuntelija(Treeniloki treeniloki, JFormattedTextField minH, JFormattedTextField minM, JFormattedTextField maxH, JFormattedTextField maxM, JLabel arvottu){
        this.treeniloki = treeniloki;
        this.minH = minH;
        this.minM = minM;
        this.maxH = maxH;
        this.maxM = maxM;
        this.arvottu = arvottu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int minTunnit = (Integer)minH.getValue();
        int minMinuutit = (Integer)minM.getValue();
        int maxTunnit = (Integer)maxH.getValue();
        int maxMinuutit = (Integer)maxM.getValue();
        
        String arvottuTeksti = treeniloki.arvoTreeni(minTunnit, minMinuutit, maxTunnit, maxMinuutit, treeniloki.getUrheilulajit());
        
        arvottu.setText(arvottuTeksti);
        
    }
    
}
