/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sovelluslogiikka.Treeniloki;

/**
 *
 * @author Heini
 */
public class OnnistuukoKirjautuminenKuuntelija implements ActionListener{
    private JFrame frame;
    private Treeniloki treeniloki;
    private JFrame frameKirjaudu;
    private JTextField kayttajatunnus;
    private JPasswordField salasana;
    
    public OnnistuukoKirjautuminenKuuntelija(JFrame frame, Treeniloki treeniloki, JFrame frameKirjaudu, JTextField kayttajatunnus, JPasswordField salasana){
        this.frame = frame;
        this.treeniloki = treeniloki;
        this.frameKirjaudu = frameKirjaudu;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(treeniloki.Kirjaudu(this.kayttajatunnus.getText(), this.salasana.getText())){
            frame.dispose();
            frameKirjaudu.dispose();
            
            JFrame frameMuokkaa = new JFrame(treeniloki.toString());
            frameMuokkaa.setPreferredSize(new Dimension(500, 400));
        
            frameMuokkaa.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
            luoKomponentit(frameMuokkaa.getContentPane());
        
            frameMuokkaa.pack(); 
            frameMuokkaa.setVisible(true);
        } else {
            System.out.println("Syötä uudestaan");
        }
        
    }
    
    public void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(6,1);
        container.setLayout(layout);
        
        JButton lisaaUrheilulaji = new JButton("Lisää urheilulaji");
        lisaaUrheilulaji.addActionListener(new LisaaUrheilulajiKuuntelija(treeniloki));
        JButton lisaaTreeni = new JButton ("Lisää treeni");
        lisaaTreeni.addActionListener(new LisaaTreeniKuuntelija(treeniloki));
        JButton arvoTreeni = new JButton("Arvo treeni");
        arvoTreeni.addActionListener(new ArvoTreeniKuuntelija(treeniloki));
        JButton naytaKooste = new JButton("Näytä kooste");
        naytaKooste.addActionListener(new NaytaKoosteKuuntelija(treeniloki));
        JButton naytaGraafinenKooste = new JButton("Näytä kooste graafisesti");
        JButton poistu = new JButton("Poistu");
        
        container.add(lisaaUrheilulaji);
        container.add(lisaaTreeni);
        container.add(arvoTreeni);
        container.add(naytaKooste);
        container.add(naytaGraafinenKooste);
        container.add(poistu);
    }
    
}
