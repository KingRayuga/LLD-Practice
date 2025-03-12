package ATM;

public class UpdateBalanceHandler extends WithdrawalHandler{
    private WithdrawalHandler next;

    UpdateBalanceHandler(WithdrawalHandler next) {

    }

    UpdateBalanceHandler() {
        this.next = null;
    }

    public void handle(Session session) {
        session.getUser().getAccount().withdraw(session.getRequestedAmount());
        System.out.println("Balance updated");
    }

    public void setNext(WithdrawalHandler next) {
        this.next = next;
    }
}
