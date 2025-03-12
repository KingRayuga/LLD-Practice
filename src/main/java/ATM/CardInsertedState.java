package ATM;

public class CardInsertedState implements ATMState{
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void enterPIN(int pin) {
        if (atm.getSession().getUser().getCard().validatePin(pin)) {
            System.out.println("PIN validated");
            atm.setState(new MenuState(atm));
        } else {
            System.out.println("Invalid PIN");
        }
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void displayOptions() {
        System.out.println("Enter PIN first");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Enter PIN first");
    }

    @Override
    public void ejectCard() {
        atm.setState(new IdleState(atm));
        System.out.println("Card ejected");
    }
}
