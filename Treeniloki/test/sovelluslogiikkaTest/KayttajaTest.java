/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikkaTest;

import sovelluslogiikka.Kayttaja;
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
public class KayttajaTest {
    
    Kayttaja kayttaja;
    
    public KayttajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kayttaja = new Kayttaja("testikayttaja", "testisalasana");
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
    public void tunnistaaOikeanKayttajatunnuksenJaSalasanan(){
        boolean vastaus = kayttaja.tunnistautuminenOnnistui("testikayttaja", "testisalasana");
        
        assertEquals(true, vastaus);
    }
    
    @Test
    public void tunnistaaVaaranKayttajatunnuksen(){
        boolean vastaus = kayttaja.tunnistautuminenOnnistui("kayttaja", "testisalasana");
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void tunnistaaVaaranSalasanan(){
        boolean vastaus = kayttaja.tunnistautuminenOnnistui("testikayttaja", "salasana");
        
        assertEquals(false, vastaus);
    }
    
    @Test
    public void vaihtaaKayttajatunnuksenJosKayttajatunnusJaSalasanaOikein(){
        kayttaja.vaihdaKayttajatunnus("testikayttaja", "testisalasana", "uusikayttaja");
        String vastaus = kayttaja.getKayttajatunnus();
        
        assertEquals("uusikayttaja", vastaus);
    }
    
    @Test
    public void eiVaihdaKayttajatunnustaJosSalasanaVaarin(){
        kayttaja.vaihdaKayttajatunnus("testikayttaja", "salasana", "uusikayttaja");
        String vastaus = kayttaja.getKayttajatunnus();
        
        assertEquals("testikayttaja", vastaus);
    }
    
    @Test
    public void eiVaihdaKayttajatunnustaJosKayttajatunnusVaarin(){
        kayttaja.vaihdaKayttajatunnus("kayttaja", "testisalasana", "uusikayttaja");
        String vastaus = kayttaja.getKayttajatunnus();
        
        assertEquals("testikayttaja", vastaus);
    }
    
}
