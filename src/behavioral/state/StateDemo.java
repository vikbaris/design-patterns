package behavioral.state;

public class StateDemo {
    public static void main(String[] args) {
        // Yeni bir sipariş oluştur
        Order order = new Order("12345");
        System.out.println("Sipariş durumu: " + order.getStatus());

        // Normal sipariş akışı
        order.confirmOrder();
        System.out.println("Sipariş durumu: " + order.getStatus());

        order.shipOrder();
        System.out.println("Sipariş durumu: " + order.getStatus());

        order.deliverOrder();
        System.out.println("Sipariş durumu: " + order.getStatus());

        // Teslim edilmiş siparişi iptal etmeye çalış
        order.cancelOrder();

        System.out.println("\n--- Yeni Sipariş ---");
        // Yeni bir sipariş oluştur ve hatalı işlemler dene
        Order order2 = new Order("67890");
        System.out.println("Sipariş durumu: " + order2.getStatus());

        // Kargolanmamış siparişi teslim etmeye çalış
        order2.deliverOrder();

        // Siparişi iptal et
        order2.cancelOrder();
        System.out.println("Sipariş durumu: " + order2.getStatus());

        // İptal edilmiş siparişi onaylamaya çalış
        order2.confirmOrder();
    }
}
