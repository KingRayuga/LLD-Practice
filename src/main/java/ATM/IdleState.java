package ATM;

public class IdleState implements ATMState{
    private ATM atm;


    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted");
        atm.setState(new CardInsertedState(atm));
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("Please insert card first");
    }

    @Override
    public void displayOptions() {
        System.out.println("Please insert card first");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Please insert card first");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject");
    }
}
