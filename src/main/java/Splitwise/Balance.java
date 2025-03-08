package Splitwise;

public class Balance {
    private double lend;
    private double borrow;

    public Balance(double lend, double borrow) {
        this.lend = lend;
        this.borrow = borrow;
    }

    public double getBorrow() {
        return borrow;
    }

    public double getLend() {
        return lend;
    }

    public void setBorrow(double borrow) {
        this.borrow = borrow;
    }

    public void setLend(double lend) {
        this.lend = lend;
    }
}
