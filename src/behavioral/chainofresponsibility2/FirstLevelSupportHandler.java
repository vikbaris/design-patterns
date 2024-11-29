package behavioral.chainofresponsibility2;

class FirstLevelSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        // Düşük seviye problemleri çözebilir
        if (ticket.getSeverity() <= 3) {
            System.out.println("1. Seviye Destek: Talep çözüldü - " + ticket.getDescription());
        } else if (nextHandler != null) {
            // Kendi çözemezse bir sonraki handler'a gönderir
            System.out.println("1. Seviye Destek: Talep çözülemedi, bir üst seviyeye aktarılıyor.");
            nextHandler.handleRequest(ticket);
        }
    }
}
