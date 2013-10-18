/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.sovelluslogiikkaTest;

import treeniloki.sovelluslogiikka.Kayttaja;
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
    public void vaihtaaSalasananUuteen(){
        kayttaja.vaihdaSalasana("uusi");
        String salasana = kayttaja.getSalasana();
        
        assertEquals("uusi", salasana);
    }
    
    @Test
    public void vaihtaaKayttajatunnuksenUuteen(){
        kayttaja.vaihdaKayttajatunnus("Käyttäjä");
        String kayttis = kayttaja.getKayttajatunnus();
        
        assertEquals("Käyttäjä", kayttis);
    }

}
