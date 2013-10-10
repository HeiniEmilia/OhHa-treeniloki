/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import sovelluslogiikka.Treeniloki;
import sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class TarkasteleTreenilokiaKuuntelija implements ActionListener{
    private JList treenilokiLista;
    TreenilokiTietokanta treenilokit;
    
    public TarkasteleTreenilokiaKuuntelija (JList lista, TreenilokiTietokanta treenilokit){
        this.treenilokiLista = lista;
        this.treenilokit = treenilokit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = treenilokiLista.getSelectedIndex();
        Treeniloki treeniloki = treenilokit.getTreenilokit().get(index);
        JFrame frame = new JFrame(treeniloki.toString());
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack(); 
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JButton naytaLajit = new JButton("Näytä urheilulajit");
        JButton naytaKooste = new JButton("Näytä kooste");
        JButton naytaGraafinenKooste = new JButton("Näytä kooste graafisesti");
        
        container.add(naytaLajit);
        container.add(naytaKooste);
        container.add(naytaGraafinenKooste);
    }
}
