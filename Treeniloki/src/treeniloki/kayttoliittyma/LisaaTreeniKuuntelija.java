/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.Urheilulaji;

/**
 *
 * @author Heini
 */
public class LisaaTreeniKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    private JFrame frame;

    public LisaaTreeniKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        frame = new JFrame("Treeniloki");
        frame.setPreferredSize(new Dimension(300, 200));
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        ArrayList<Urheilulaji> urheilulajit = treeniloki.getUrheilulajit();
        if(urheilulajit.isEmpty()){
            container.add(new JLabel("Lisää ensin urheilulajeja!"));
        } else {
        JList urheilulajiLista = new JList(urheilulajit.toArray());
        urheilulajiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        urheilulajiLista.setLayoutOrientation(JList.VERTICAL);
        urheilulajiLista.setSelectedIndex(0);
        
        JScrollPane skrolleri = new JScrollPane(urheilulajiLista);
        skrolleri.setPreferredSize(new Dimension(300,200));
        
        container.add(skrolleri);
        
        JPanel alapaneeli = new JPanel (new GridLayout(1,5));
        
        JFormattedTextField tunnitKentta = new JFormattedTextField(0);
        JLabel tunnit = new JLabel("h");
        JFormattedTextField minuutitKentta = new JFormattedTextField(0);
        JLabel minuutit = new JLabel ("min");
        
        JButton lisaaNappi = new JButton ("Lisää!");
        lisaaNappi.addActionListener(new TreeniKuuntelija(frame, treeniloki, urheilulajiLista, tunnitKentta, minuutitKentta));
        
        alapaneeli.add(tunnitKentta);
        alapaneeli.add(tunnit);
        alapaneeli.add(minuutitKentta);
        alapaneeli.add(minuutit);
        alapaneeli.add(lisaaNappi);
        
        container.add(alapaneeli, BorderLayout.SOUTH);
        }
    }
    
}
