/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikkaTest;

import sovelluslogiikka.Treeniloki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Heini
 */
public class TreenilokiTest {
    Treeniloki treeniloki;
    
    public TreenilokiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        treeniloki = new Treeniloki("Nimi", "kayttajatunnus", "salasana");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void alussaLokissaEiYhtaanLajeja(){
        int vastaus = treeniloki.urheilulajienMaara();
        
        assertEquals(0, vastaus);
    }
    
    public void lajinLisaysLisaaLajienMaaraa(){
        treeniloki.luoUusiUrheilulaji("Tennis");
        int vastaus = treeniloki.urheilulajienMaara();
        
        assertEquals(1, vastaus);
    }
    
}
