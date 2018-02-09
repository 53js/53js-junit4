/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit4;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MoneyTest {
    
  public MoneyTest() {
    }

    private Money bitcoin10;
    private Money bitcoint15;

    @Before
    public void setUp() {
        System.out.println("BeforeEach");
        bitcoin10 = new Money(10, "BTC");
        bitcoint15 = new Money(15, "BTC");
    }
    
    @Test
    public void currencyUppercase() {
        Money m = new Money(10,"eur");
        assertTrue(m.getCurrency().equals("EUR"));
        m.setCurrency("eur");
        assertTrue(m.getCurrency().equals("EUR"));
    }
    
    @Test
    public void testEquals() {
        // test avec null 
        assertFalse(bitcoin10.equals(null));
        
        // test de l'égalité avec soit même 
        assertEquals(bitcoin10, bitcoin10);
        
        // test avec un autre instance 
        assertEquals(bitcoin10, new Money(10, "BTC"));
        
        // test entre deux instances qui ont des valeurs différentes
        assertTrue(!bitcoin10.equals(bitcoint15));
        
        bitcoint15.setAmount(10);
        assertTrue(bitcoin10.equals(bitcoint15));
    }

    @After
    public void cleanUp() {
        bitcoin10  = null;
        bitcoint15 = null;
        System.out.println("After");
    }


}
