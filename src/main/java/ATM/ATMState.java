package ATM;

public interface ATMState {
    public void insertCard(Card card);
    public void enterPIN(int pin);
    public void displayOptions();
    public void requestCash(int amount);
    public void ejectCard();
}
