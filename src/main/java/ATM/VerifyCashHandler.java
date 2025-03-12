package ATM;

public class VerifyCashHandler extends WithdrawalHandler {
    private WithdrawalHandler next;

    @Override
    public void handle(Session session) {
        ATM atm = ATM.getInstance();
        double amount = session.getRequestedAmount();

        double remaining = amount;
        for (int note : atm.getCashDeposit().keySet()) {
            int count = (int) Math.min(remaining / note, atm.getCashDeposit().get(note));
            remaining -= count * note;
        }

        if (remaining - amount < 1) {
            if (next != null) next.handle(session);
        } else {
            System.out.println("ATM does not have enough cash for this transaction.");
        }
    }

    @Override
    public void setNext(WithdrawalHandler next) {
        this.next = next;
    }
}
