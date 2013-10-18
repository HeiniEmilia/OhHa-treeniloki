/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class TarkasteleTreenilokiaKuuntelija implements ActionListener{
    private JList treenilokiLista;
    private TreenilokiTietokanta treenilokit;
    private Treeniloki treeniloki;
    private JFrame frame;
    
    public TarkasteleTreenilokiaKuuntelija (JFrame frame, JList lista, TreenilokiTietokanta treenilokit){
        this.treenilokiLista = lista;
        this.treenilokit = treenilokit;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.dispose();
        int index = treenilokiLista.getSelectedIndex();
        this.treeniloki = treenilokit.getTreenilokit().get(index);
        JFrame frameTarkastele = new JFrame(treeniloki.toString());
        frameTarkastele.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frameTarkastele.getContentPane());
        
        frameTarkastele.setPreferredSize(new Dimension(500, 400));
        frameTarkastele.pack(); 
        frameTarkastele.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JButton naytaKooste = new JButton("Näytä kooste");
        naytaKooste.addActionListener(new NaytaKoosteKuuntelija(treeniloki));
        JButton naytaGraafinenKooste = new JButton("Näytä kooste graafisesti");
        naytaGraafinenKooste.addActionListener(new NaytaGraafinenKoosteKuuntelija(treeniloki));
        JButton poistu = new JButton ("Poistu");
        poistu.addActionListener(new PoistuKuuntelija(frame));
                
        container.add(naytaKooste);
        container.add(naytaGraafinenKooste);
        container.add(poistu);
    }
}
