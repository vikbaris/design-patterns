package behavioral.chainofresponsibility;

public class Dispenser100 extends MoneyDispenser {
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 100) {
            int num = currency.getAmount() / 100;
            int remainder = currency.getAmount() % 100;
            System.out.println("Dispensing " + num + " 100TL note(s)");
            
            if (remainder != 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new Currency(remainder));
            }
        } else if (this.nextDispenser != null) {
            this.nextDispenser.dispense(currency);
        }
    }
}
