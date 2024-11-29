package behavioral.chainofresponsibility2;

abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public SupportHandler setNextHandler(SupportHandler next) {
        this.nextHandler = next;
        return next;
    }

    public abstract void handleRequest(SupportTicket ticket);
}
