/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit4;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author François
 */
public class WalletTest {
    
    private Wallet myWallet;
    private  Money eur10;
    private  Money eur160;
    private  Money usd10;
    private  Money yen1000;
    
    
    public WalletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myWallet = new Wallet("myWallet");
        eur10 = new Money(10, "EUR");
        eur160 = new Money(160, "EUR");
        usd10 = new Money(10, "USD", 0.81);
        yen1000 = new Money(10, "YEN", 0.0073);
    }
    
    @After
    public void tearDown() {
        myWallet = null;
        eur10 = null;
        eur160 = null;
        usd10 = null;
        yen1000 = null;
    }

    @Test
    public void testIdGeneration() {
        int nb = Wallet.getNb();
        Wallet test = new Wallet("myTestWallet");
        assertTrue(nb == test.getId());
        assertTrue(myWallet.getId() < test.getId());
    }

    /**
     * Test of add method, of class Wallet.
     */
    
    @Test(expected = Exception.class)
    public void testCreateAmountNegative() {
        new Money(-10, "EUR");
    }

    @Test(expected = Exception.class)
    public void testCreateAmountZero() {
        new Money(0, "EUR");
    }
    
    @Test
    public void testCreate() {
        Money testEur = new Money(1, "EUR");
        assertTrue(testEur.getAmount() == 1);
        assertTrue(testEur.getCurrency().equals("EUR"));
        assertTrue(testEur.getChange() == 1);
        
        Money testEur2 = new Money(1, "eur");
        assertTrue(testEur2.getCurrency().equals("EUR"));
    }

    @Test
    public void testAddSize() {
        // ajout d'un money
        myWallet.add(eur10);
        assertEquals(1, myWallet.getContent().size());
        assertEquals(10, myWallet.getContent().get("EUR").getAmount(), 0.1);
        
        // ajout de la même money
        myWallet.add(eur10);
        assertEquals(1, myWallet.getContent().size());
        assertEquals(20, myWallet.getContent().get("EUR").getAmount(), 0.1);
        
        // ajout d'un autre money
        myWallet.add(yen1000);
        assertEquals(2, myWallet.getContent().size());
        assertEquals(1000, myWallet.getContent().get("YEN").getAmount(), 0.1);
        assertEquals(20, myWallet.getContent().get("EUR").getAmount(), 0.1);
        
        // test ajout d'un money deja existante
        // test que cela ne modifie pas les moneys existantes
        myWallet.add(yen1000);
        assertEquals(2, myWallet.getContent().size());
        assertEquals(2000, myWallet.getContent().get("YEN").getAmount(), 0.1);
        assertEquals(20, myWallet.getContent().get("EUR").getAmount(), 0.1);
    }

    /**
     * Test of remove method, of class Wallet.
     */
    @Test
    public void testRemoveSize() {
        // tester que la taille de la hasmap diminue si le montant devient 0
        myWallet.add(eur10);
        myWallet.remove(eur10);
        assertEquals(0, myWallet.getContent().size());
    }

      @Test
    public void testRemoveSizeBis() {
        myWallet.add(eur10);
        myWallet.add(yen1000);
        myWallet.remove(eur10);
        assertEquals(1, myWallet.getContent().size());
    }
    
    @Test
    public void testRemoveAmount() {
          // tester aussi le montant est bien calculé 
        myWallet.add(eur10);
        myWallet.add(eur160);
        myWallet.remove(new Money(70, "EUR"));
        // 170 - 70 
        assertEquals(1, myWallet.getContent().size());
        assertEquals(100, myWallet.getContent().get("EUR").getAmount(), 0.1);
    }
    
    @Test(expected = Exception.class)
    public void testRemoveNegativeValue() {
        // montant négatif
        myWallet.add(eur160);
        myWallet.remove(new Money(200, "EUR"));
    }
    
    @Test(expected = Exception.class)
    public void testMoneyDoNotExist() {
        // Suppression d'une money qui n'existe pas 
        myWallet.remove(new Money(200, "EUR"));
    }
    

    /**
     * Test of toEur method, of class Wallet.
     */
    @Test
    public void testToEur() {
        System.out.println("toEur");
        
        myWallet.add(eur10);
        myWallet.add(usd10);
        
        double walletValue = myWallet.toEur();
        double exceptedResult = 10 + 10 * 0.81;
        
        assertEquals(exceptedResult, walletValue, 0.001);
    }
    
     @Test
    public void testToEurEmptyWallet() {
        double exceptedResult = 0;
        double walletValue = myWallet.toEur();
        assertEquals(exceptedResult, walletValue, 0.001);
    }
    
}
