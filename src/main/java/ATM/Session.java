package ATM;

public class Session {
    private final User user;
    private double requestedAmount;

    Session(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(double requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
}
