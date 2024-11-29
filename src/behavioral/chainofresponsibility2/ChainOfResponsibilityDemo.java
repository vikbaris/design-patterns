package behavioral.chainofresponsibility2;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Destek zincirini oluştur
        FirstLevelSupportHandler firstLevel = new FirstLevelSupportHandler();
        SecondLevelSupportHandler secondLevel = new SecondLevelSupportHandler();
        ManagerSupportHandler managerLevel = new ManagerSupportHandler();

        // Zinciri bağla
        firstLevel.setNextHandler(secondLevel)
                 .setNextHandler(managerLevel);

        // Farklı önem seviyelerinde talepler oluştur
        SupportTicket[] tickets = {
            new SupportTicket(2, "Yazılım güncellemesi gerekiyor"),
            new SupportTicket(5, "Sunucu performans problemi"),
            new SupportTicket(8, "Kritik sistem arızası")
        };

        // Her talebi işle
        for (SupportTicket ticket : tickets) {
            System.out.println("\nYeni Destek Talebi - Önem Seviyesi: " + ticket.getSeverity());
            firstLevel.handleRequest(ticket);
        }
    }
}
