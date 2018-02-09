/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author François
 */
public class Wallet implements IWallet {
    
    private static int nb = 1;
    private int id;
    private String name;
    private HashMap<String, Money> content;
    
    public Wallet(String name) {
        this.name = name;
        this.id = nb;
        nb += 1;
        this.content = new HashMap<>();
        
    }

    public static int getNb() {
        return nb;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Money> getContent() {
        return content;
    }

    public void setContent(HashMap<String, Money> content) {
        this.content = content;
    }
    
    
    // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#containsKey(java.lang.Object)
    // containsKey
    // get
    // put
    // remove
    // forEach
    
    public void add(Money m) {
        // ajout la money 
        // vérifier si elle existe deja dans le wallet 
        // si oui modifier le montant
        // si non on ajout (key <=> m.getCurrency)
        
        // wallet.add(new Money(10, "EUR"))
        // wallet {
        //  "EUR" : 10
        // }
        
        // wallet.add(new Money(10, "EUR"))
        // wallet {
        //  "EUR" : 20
        // }
        
        // wallet.add(new Money(10, "USD"))
        // wallet {
        //  "EUR" : 20,
        //  "USD" : 10
        // }
        
        
    }

    public void remove(Money m) {
        // supprimer la money m passée en paremtre
        // lever une erreur si elle n'existe pas 
        // lever une erreur si le montant devient négatif
        
    }

    public double toEur() {
        // calculer la valeur en euro du wallet 
        // utiliser l'attribut change de money
    }

    @Override
    public String toString() {
        String s = "Wallet{" + " name=" + name + ", content=";
        
        for(Map.Entry<String, Money> entry : content.entrySet()) {
            String key = entry.getKey();
            Money value = entry.getValue();
            
            s += "Key: " + key + " value : " + value;
        }
        
        s+= "}";
        return s;
    }
    
    
    
    
}
