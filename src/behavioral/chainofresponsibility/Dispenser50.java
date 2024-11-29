package behavioral.chainofresponsibility;

public class Dispenser50 extends MoneyDispenser {
    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50TL note(s)");
            
            if (remainder != 0 && this.nextDispenser != null) {
                this.nextDispenser.dispense(new Currency(remainder));
            }
        } else if (this.nextDispenser != null) {
            this.nextDispenser.dispense(currency);
        } else {
            System.out.println("Cannot dispense remaining amount: " + currency.getAmount());
        }
    }
}
