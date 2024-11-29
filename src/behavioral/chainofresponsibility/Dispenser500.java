package behavioral.chainofresponsibility;

public class Dispenser500 extends MoneyDispenser {
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 500) {
            int num = currency.getAmount() / 500;
            int remainder = currency.getAmount() % 500;
            System.out.println("Dispensing " + num + " 500TL note(s)");
            
            if (remainder != 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new Currency(remainder));
            }
        } else if (this.nextDispenser != null) {
            this.nextDispenser.dispense(currency);
        }
    }
}
