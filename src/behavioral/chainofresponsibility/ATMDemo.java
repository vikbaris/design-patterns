package behavioral.chainofresponsibility;

public class ATMDemo {
    public static void main(String[] args) {
        // Dispenser zincirini oluştur
        MoneyDispenser dispenser500 = new Dispenser500();
        MoneyDispenser dispenser200 = new Dispenser200();
        MoneyDispenser dispenser100 = new Dispenser100();
        MoneyDispenser dispenser50 = new Dispenser50();

        // Zinciri bağla
        dispenser500.setNextDispenser(dispenser200);
        dispenser200.setNextDispenser(dispenser100);
        dispenser100.setNextDispenser(dispenser50);

        // Test senaryoları
        System.out.println("1750 TL çekme işlemi:");
        dispenser500.dispense(new Currency(1750));
        
        System.out.println("\n375 TL çekme işlemi:");
        dispenser500.dispense(new Currency(375));
        
        System.out.println("\n2000 TL çekme işlemi:");
        dispenser500.dispense(new Currency(2000));
    }
}
