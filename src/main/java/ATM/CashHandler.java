package ATM;

public class CashHandler extends WithdrawalHandler{
    private WithdrawalHandler next;

    @Override
    public void handle(Session session) {
        ATM atm = ATM.getInstance();
        double amount = session.getRequestedAmount();

        for (int note : atm.getCashDeposit().keySet()) {
            double count = Math.min(amount / note, atm.getCashDeposit().get(note));
            amount -= count * note;
            atm.getCashDeposit().put(note, (int) (atm.getCashDeposit().get(note) - count));
            System.out.println("Dispensed " + count + " x " + note);
        }

        if (next != null) next.handle(session);
    }

    @Override
    public void setNext(WithdrawalHandler next) {
        this.next = next;
    }
}
