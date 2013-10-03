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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        DefaultListModel muutettavaLista = new DefaultListModel();
        for (Treeniloki treeniloki: kaikkiLokit){
            muutettavaLista.addElement(treeniloki);
        }
        JList treenilokiLista = new JList(muutettavaLista);
        treenilokiLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        treenilokiLista.setLayoutOrientation(JList.VERTICAL);
        
        JPanel vaihtoehtoPainikkeet = luoVaihtoehdot(kaikkiLokit);
        
        treenilokiLista.addListSelectionListener(new TreenilokiListastaKuuntelija(muutettavaLista, treenilokiLista, vaihtoehtoPainikkeet));
        
        container.add(treenilokiLista);
        container.add(vaihtoehtoPainikkeet, BorderLayout.SOUTH);
        
    }
    
     private JPanel luoVaihtoehdot(ArrayList<Treeniloki> kaikkiTreenilokit){
        JPanel valintaPaneeli = new JPanel (new GridLayout(1,3));
        
        JButton kirjauduNappi = new JButton("Kirjaudu");
        JButton tarkasteleNappi = new JButton("Tarkastele");
        JButton luoUusiNappi = new JButton("Luo Uusi");
        
        //if (kaikkiTreenilokit.isEmpty()){
            //kirjauduNappi.setEnabled(false);
            //tarkasteleNappi.setEnabled(false);
        //}
        
        kirjauduNappi.addActionListener(new KirjauduKuuntelija());
        valintaPaneeli.add(kirjauduNappi);
        
        tarkasteleNappi.addActionListener(new TarkasteleTreenilokiaKuuntelija());
        valintaPaneeli.add(tarkasteleNappi);
        
        luoUusiNappi.addActionListener(new ValitseLuoUusiKuuntelija(treenilokit));
        valintaPaneeli.add(luoUusiNappi);
        
        return valintaPaneeli;
    }
     
    
    public class TreenilokiListastaKuuntelija implements ListSelectionListener{
        private DefaultListModel apuLista;
        private JList lokit;
        private JPanel painikkeet;
    
        public TreenilokiListastaKuuntelija(DefaultListModel muutettavaLista, JList treenilokiLista, JPanel vaihtoehdot){
            this.apuLista = muutettavaLista;
            this.lokit = treenilokiLista;
            this.painikkeet = vaihtoehdot;
        }
    
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                if (lokit.getSelectedIndex() == -1) {
                    painikkeet.setVisible(false);
                } else {
                    painikkeet.setVisible(true);
                }
            }
        }
    
    }
    
}
