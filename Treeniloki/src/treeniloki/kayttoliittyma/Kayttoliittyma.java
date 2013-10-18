/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.TreenilokiTietokanta;

/**
 *
 * @author Heini
 */
public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    private TreenilokiTietokanta treenilokit;
    private TiedostoonKirjoittaja tallentaja;
    private TiedostostaLukija lukija;
    
    public Kayttoliittyma()throws Exception{
        this.lukija = new TiedostostaLukija();
        this.treenilokit = lukija.palautaTiedostosta();
        this.tallentaja = new TiedostoonKirjoittaja();
    }
    
    @Override
    public void run(){
        Thread t = new Thread(){
            @Override
            public void run(){
                tallentaja.tallennaTiedostoon(treenilokit);
            }
        };
        Runtime.getRuntime().addShutdownHook(t);
        frame = new JFrame("Treeniloki");
        frame.setPreferredSize(new Dimension(500, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        ArrayList<Treeniloki> kaikkiLokit = treenilokit.getTreenilokit();
        JList treenilokiLista = new JList(kaikkiLokit.toArray());
        treenilokiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        treenilokiLista.setLayoutOrientation(JList.VERTICAL);
        
        JScrollPane skrolleri = new JScrollPane(treenilokiLista);
        skrolleri.setPreferredSize(new Dimension(450, 350));
        
        JPanel vaihtoehtoPainikkeet = luoVaihtoehdot(kaikkiLokit, treenilokiLista);
        
        container.add(skrolleri);
        container.add(vaihtoehtoPainikkeet, BorderLayout.SOUTH);
        
    }
    
     private JPanel luoVaihtoehdot(ArrayList<Treeniloki> kaikkiTreenilokit, JList lista){
        JPanel valintaPaneeli = new JPanel (new GridLayout(1,3));
        
        JButton kirjauduNappi = new JButton("Kirjaudu");
        JButton tarkasteleNappi = new JButton("Tarkastele");
        JButton luoUusiNappi = new JButton("Luo Uusi");
        lista.setSelectedIndex(0);
        
        if (kaikkiTreenilokit.isEmpty()){
            kirjauduNappi.setEnabled(false);
            tarkasteleNappi.setEnabled(false);
        }
        
        kirjauduNappi.addActionListener(new KirjauduKuuntelija(frame, lista, treenilokit));
        valintaPaneeli.add(kirjauduNappi);
        
        tarkasteleNappi.addActionListener(new TarkasteleTreenilokiaKuuntelija(frame, lista, treenilokit));
        valintaPaneeli.add(tarkasteleNappi);
        
        luoUusiNappi.addActionListener(new UusiTreenilokiKuuntelija(frame, treenilokit));
        valintaPaneeli.add(luoUusiNappi);
        
        return valintaPaneeli;
    }
   
}