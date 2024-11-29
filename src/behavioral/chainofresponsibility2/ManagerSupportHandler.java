package behavioral.chainofresponsibility2;

class ManagerSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        // Yüksek seviye problemleri çözebilir
        if (ticket.getSeverity() > 6) {
            System.out.println("Yönetici Seviye Destek: Talep çözüldü - " + ticket.getDescription());
        } else if (nextHandler != null) {
            System.out.println("Yönetici Seviye Destek: Talep çözülemedi, başka bir yol bulunamadı.");
            nextHandler.handleRequest(ticket);
        }
    }
}
