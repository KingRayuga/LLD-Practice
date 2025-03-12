package ATM;

public abstract class WithdrawalHandler {
    public abstract void handle(Session session);
    public abstract void setNext(WithdrawalHandler next);
}
