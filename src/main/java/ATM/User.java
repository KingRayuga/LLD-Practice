package ATM;

public class User {
    private final String name;
    private final Card card;
    private final BankAccount account;

    public User(String name, Card card, BankAccount account){
        this.name = name;
        this.card = card;
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }
}
