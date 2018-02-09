/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit4;

/**
 *
 * @author François
 */
public class Junit4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Money eur10 = new Money(10, "EUR");
        Wallet myWallet = new Wallet("myWallet");
        
        myWallet.add(eur10);
        
        System.out.println(myWallet);
    }
    
}
