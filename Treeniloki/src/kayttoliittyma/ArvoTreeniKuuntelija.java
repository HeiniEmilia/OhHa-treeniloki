/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class ArvoTreeniKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    
    public ArvoTreeniKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
