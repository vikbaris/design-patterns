package behavioral.chainofresponsibility;

public class Dispenser200 extends MoneyDispenser {
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 200) {
            int num = currency.getAmount() / 200;
            int remainder = currency.getAmount() % 200;
            System.out.println("Dispensing " + num + " 200TL note(s)");
            
            if (remainder != 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new Currency(remainder));
            }
        } else if (this.nextDispenser != null) {
            this.nextDispenser.dispense(currency);
        }
    }
}
