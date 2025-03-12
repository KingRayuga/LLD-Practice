package ATM;

public class Card {
    private final String cardNumber;
    private transient final int pin;

    Card(String cardNumber, int pin){
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean validatePin(int pin){
        return this.pin == pin;
    }
}
