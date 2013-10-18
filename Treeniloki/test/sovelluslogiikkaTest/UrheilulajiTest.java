package sovelluslogiikkaTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import treeniloki.sovelluslogiikka.Urheilulaji;
import static org.junit.Assert.*;


/**
 *
 * @author Heini
 */
public class UrheilulajiTest {
    
    Urheilulaji laji1;
    Urheilulaji laji2;
    
    public UrheilulajiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        laji1 = new Urheilulaji("hiihto");
        laji2 = new Urheilulaji("juoksu");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    //public void hello() {}
    
    @Test
    public void konstruktoriAsettaaNimenJaAjanOikein(){
        String vastaus = laji1.toString();
        
        assertEquals("hiihto 0:00", vastaus);
    }
    
    @Test
    public void lisaaTunnitOikein(){
        laji1.lisaaAika(2,0);
        String vastaus = laji1.toString();
        
        assertEquals("hiihto 2:00", vastaus);
    }
    
    @Test
    public void lisaaAlleKuusikymmentaMinuuttiaOikein(){
        laji1.lisaaAika(0,50);
        String vastaus = laji1.toString();
        
        assertEquals("hiihto 0:50", vastaus);
    }
    
    @Test
    public void lisaaTasanKuusikymmentaMinuuttiaOikein(){
        laji1.lisaaAika(0,60);
        String vastaus = laji1.toString();
        
        assertEquals("hiihto 1:00", vastaus);
    }
    
    @Test
    public void lisaaYliKuusikymmentaMinuuttiaOikein(){
        laji1.lisaaAika(0,50);
        laji1.lisaaAika(0,45);
        String vastaus = laji1.toString();
        
        assertEquals("hiihto 1:35", vastaus);
    }
    
    @Test
    public void suurempiAikaPalauttaaTrue(){
        laji1.lisaaAika(0,50);
        laji2.lisaaAika(0,45);
        boolean vastaus = laji1.suurempiAika(laji2);
        
        assertEquals(true, vastaus);
    }
        
    @Test
    public void pienempiAikaPalauttaaFalse(){
        laji1.lisaaAika(0,50);
        laji2.lisaaAika(0,45);
        boolean vastaus = laji2.suurempiAika(laji1);
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void samatAjatPalauttaaFalse(){
        laji1.lisaaAika(0,50);
        laji2.lisaaAika(0,50);
        boolean vastaus = laji2.suurempiAika(laji1);
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void tunnistaaSamatAjat(){
        laji1.lisaaAika(0,50);
        laji2.lisaaAika(0,50);
        boolean vastaus = laji2.samatAjat(laji1);
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void tunnistaaEriAjat(){
        laji1.lisaaAika(0,40);
        laji2.lisaaAika(0,50);
        boolean vastaus = laji2.samatAjat(laji1);
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void alussaEiTreenimuotoja(){
        int vastaus = laji1.treenimuotojenMaara();
        
        assertEquals(0, vastaus);
    }
    
    @Test
    public void TreenimuodonLisaysLisaaNiidenMaaraa(){
        laji1.lisaaLajilleTreenimuotoja("Kilpailu");
        laji1.lisaaLajilleTreenimuotoja("Harjoitukset");
        int vastaus = laji1.treenimuotojenMaara();
        
        assertEquals(2, vastaus);
    }
}
