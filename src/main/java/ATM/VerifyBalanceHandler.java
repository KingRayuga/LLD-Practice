package ATM;

public class VerifyBalanceHandler extends WithdrawalHandler{
    private WithdrawalHandler next;

    @Override
    public void handle(Session session) {
        if (session.getUser().getAccount().getBalance() >= session.getRequestedAmount()) {
            next.handle(session);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void setNext(WithdrawalHandler next) {
        this.next = next;
    }
}
