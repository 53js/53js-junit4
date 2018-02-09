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
        Money usd10 = new Money(10, "USD", 0.82);
        Money mad10 = new Money(10, "MAD", 0.088);

        Wallet myWallet = new Wallet("myWallet");
        
        myWallet.add(eur10);
        myWallet.add(eur10);
        myWallet.add(usd10);
        myWallet.add(mad10);

       
        System.out.println(myWallet);
        System.out.println(myWallet.toEur());
        myWallet.remove(usd10);
        System.out.println(myWallet);
    }
    
}
