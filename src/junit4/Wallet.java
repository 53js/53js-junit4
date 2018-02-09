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
        String cur = m.getCurrency();
        
        if (!this.content.containsKey(cur)) {
            this.content.put(cur, m);
        } else {
            Money presente = this.content.get(cur);
            presente.setAmount(m.getAmount() + presente.getAmount());
        }
    }

    public void remove(Money m) {
        // supprimer la money m passée en paremtre
        // lever une erreur si elle n'existe pas 
        // lever une erreur si le montant devient négatif
        
        if (!this.content.containsKey(m.getCurrency())) {
            throw new Error("La Money n'existe pas");
        }
        
        // ce que je veux enlever
        String cur = m.getCurrency(); // currency
        double amount = m.getAmount(); // montant
        
        
        Money mcurrent = this.content.get(cur); // je recupere la money dans mon portefueille
       
        double newAmount = mcurrent.getAmount() - amount;
                
                
        
        if (newAmount < 0) {
            throw new Error("La maison ne fait pas crédit");
        }
              
            
        if (newAmount == 0) {
            this.content.remove(cur);
        } else {
            mcurrent.setAmount(newAmount);    
        }
    }

  
    public double toEur() {
        double res = 0;
        
        // method 1
        /*
            for(Map.Entry<String, Money> entry : content.entrySet()) {
                String key = entry.getKey();
                Money value = entry.getValue();
            }
        */
        
        // method 2
        /*
            Iterator it = content.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());
                it.remove();
            }
        */
        
        // juste la value 
        for (Money value : content.values()) {
            res += value.getAmount() * value.getChange();
        }
        
        return res;
    }
    
    @Override
    public String toString() {
        String s = "Wallet{" + "name=" + name + ", content=\n";
        
        for(Map.Entry<String, Money> entry : content.entrySet()) {
            String key = entry.getKey();
            Money value = entry.getValue();
            
            // 10 EUR
            // 10 USD 0.82
            
            // 10 * 1 + 10 * 0.82
            // 18.2 €
            
            s += "[Key: " + key + " value : " + value + "]\n";
        }
        
        s+= "}";
        return s;
    }
    
    
    
    
}
