/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import sovelluslogiikka.TiedostoonKirjoittaja;
import sovelluslogiikka.TiedostostaLukija;
import sovelluslogiikka.Treeniloki;
import sovelluslogiikka.TreenilokiTietokanta;

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
        this.tallentaja = new TiedostoonKirjoittaja();
        this.lukija = new TiedostostaLukija();
        this.treenilokit = new TreenilokiTietokanta();
        this.treenilokit.lisaaTreeniloki("Testeri", "Kayttis", "salasana");
        this.tallentaja.tallennaTiedostoon(treenilokit);
        this.treenilokit = lukija.palautaTiedostosta();
    }
    
    @Override
    public void run(){
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
        
        JPanel vaihtoehtoPainikkeet = luoVaihtoehdot(kaikkiLokit, treenilokiLista);
        
        container.add(treenilokiLista);
        container.add(vaihtoehtoPainikkeet, BorderLayout.SOUTH);
        
    }
    
     private JPanel luoVaihtoehdot(ArrayList<Treeniloki> kaikkiTreenilokit, JList lista){
        JPanel valintaPaneeli = new JPanel (new GridLayout(1,3));
        
        JButton kirjauduNappi = new JButton("Kirjaudu");
        JButton tarkasteleNappi = new JButton("Tarkastele");
        JButton luoUusiNappi = new JButton("Luo Uusi");
        
        if (kaikkiTreenilokit.isEmpty()){
            kirjauduNappi.setEnabled(false);
            tarkasteleNappi.setEnabled(false);
        }
        
        kirjauduNappi.addActionListener(new KirjauduKuuntelija(frame, lista, treenilokit));
        valintaPaneeli.add(kirjauduNappi);
        
        tarkasteleNappi.addActionListener(new TarkasteleTreenilokiaKuuntelija(lista, treenilokit));
        valintaPaneeli.add(tarkasteleNappi);
        
        luoUusiNappi.addActionListener(new UusiTreenilokiKuuntelija(frame, treenilokit));
        valintaPaneeli.add(luoUusiNappi);
        
        return valintaPaneeli;
    }
   
}