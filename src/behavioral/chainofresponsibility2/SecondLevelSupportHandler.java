package behavioral.chainofresponsibility2;

class SecondLevelSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        // Orta seviye problemleri çözebilir
        if (ticket.getSeverity() > 3 && ticket.getSeverity() <= 6) {
            System.out.println("2. Seviye Destek: Talep çözüldü - " + ticket.getDescription());
        } else if (nextHandler != null) {
            System.out.println("2. Seviye Destek: Talep çözülemedi, bir üst seviyeye aktarılıyor.");
            nextHandler.handleRequest(ticket);
        }
    }
}
