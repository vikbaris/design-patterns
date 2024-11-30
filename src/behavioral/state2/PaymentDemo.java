package behavioral.state2;

public class PaymentDemo {
    public static void main(String[] args) {
        // Başarılı ödeme senaryosu
        System.out.println("=== Başarılı Ödeme Senaryosu ===");
        Payment payment1 = new Payment("12345", 100.0);
        System.out.println("Ödeme durumu: " + payment1.getStatus());

        payment1.processPayment();
        System.out.println("Ödeme durumu: " + payment1.getStatus());

        payment1.approvePayment();
        System.out.println("Ödeme durumu: " + payment1.getStatus());

        payment1.refundPayment();
        System.out.println("Ödeme durumu: " + payment1.getStatus());

        // Başarısız ödeme senaryosu
        System.out.println("\n=== Başarısız Ödeme Senaryosu ===");
        Payment payment2 = new Payment("67890", 200.0);
        System.out.println("Ödeme durumu: " + payment2.getStatus());

        payment2.processPayment();
        System.out.println("Ödeme durumu: " + payment2.getStatus());

        payment2.declinePayment();
        System.out.println("Ödeme durumu: " + payment2.getStatus());

        // Reddedilen ödemeyi tekrar deneme
        System.out.println("\nReddedilen ödemeyi tekrar deneme:");
        payment2.processPayment();
        System.out.println("Ödeme durumu: " + payment2.getStatus());

        // Hatalı işlem denemeleri
        System.out.println("\n=== Hatalı İşlem Denemeleri ===");
        Payment payment3 = new Payment("13579", 150.0);
        
        // Onaylanmamış ödemeyi iade etmeye çalışma
        payment3.refundPayment();
        
        // İşleme alınmamış ödemeyi onaylamaya çalışma
        payment3.approvePayment();
    }
}
