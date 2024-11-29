package behavioral.chainofresponsibility;

public abstract class MoneyDispenser {
    protected MoneyDispenser nextDispenser;
    
    public void setNextDispenser(MoneyDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }
    
    public abstract void dispense(Currency currency);
}
