package ATM;

public class BankAccount {
    private transient final String accountNumber;
    private transient final String accountHolder;
    private double balance;
    private final double limit;

    public BankAccount(String accountNumber, String accountHolder, double balance, double limit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.limit = limit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isOverLimit(){
        return balance > limit;
    }

    public boolean withdraw(double amount){

        //transaction

        if(isOverLimit() || amount > balance){
            return false;
        }
        balance -= amount;

        //update balance in bank through external interface

        return true;
    }
}
