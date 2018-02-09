package junit4;

public class Money {

    private double amount; // montant
    private String currency; // euro, dollar, bitcoin
    private double change;  // taux par rapport à l'euro

    public Money(double amo, String cur) {
        this(amo, cur, 1);
    }
        
    public Money(double amo, String cur, double change) {
        this.amount = amo;
        this.currency = cur;
        this.change = change;
        // mettre le currency en uppercase
        // lever une erreur si amo est 0 ou négatif
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        // mettre le currency en uppercase
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    
    // Money a = new Money(1, "EUR");
    // Money b = new Money(1, "EUR");
    // Money c = new Money(1, "USD");
    // a.equals(b) // true 
    // a.equals(c) // false
    // a.equals(new Wallet()); // false
    
    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money aMoney = (Money) anObject;
            return aMoney.getCurrency().equals(this.getCurrency())
                    && aMoney.getAmount()== this.getAmount()
                    && aMoney.getChange() == this.getChange();
        }
        return false;
    }

}
