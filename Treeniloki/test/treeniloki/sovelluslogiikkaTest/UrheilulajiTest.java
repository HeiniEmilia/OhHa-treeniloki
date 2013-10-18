package treeniloki.sovelluslogiikkaTest;

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
    
    

}
