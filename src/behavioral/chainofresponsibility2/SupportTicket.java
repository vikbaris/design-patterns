package behavioral.chainofresponsibility2;

class SupportTicket {
    private int severity;
    private String description;

    public SupportTicket(int severity, String description) {
        this.severity = severity;
        this.description = description;
    }

    public int getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }
}
