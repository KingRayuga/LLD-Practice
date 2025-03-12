package ATM;

import java.util.Map;

public class ATM {
    private static class ATMHolder{
        private static final ATM instance = new ATM();
    }

    public static ATM getInstance(){
        return ATMHolder.instance;
    }

    private ATM(){

    }

    private Map<Integer, Integer> cashDeposit;
    private Session session;
    private ATMState state;

    public void addCash(Cash cash, int amount){
        cashDeposit.put(cash.getValue(), cashDeposit.getOrDefault(cash.getValue(), 0) + amount);
    }

    public Session getSession() {
        return session;
    }

    public void terminateSession() {
        this.session = null;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public Map<Integer, Integer> getCashDeposit() {
        return cashDeposit;
    }
}
