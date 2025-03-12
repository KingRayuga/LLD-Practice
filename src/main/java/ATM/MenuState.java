package ATM;

class MenuState implements ATMState {
    private ATM atm;

    public MenuState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void displayOptions() {
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Check Balance");
        System.out.println("3. Exit");
    }

    @Override
    public void requestCash(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        atm.getSession().setRequestedAmount(amount);
        buildHandler().handle(atm.getSession());
    }

    @Override
    public void ejectCard() {
        atm.terminateSession(); // Terminate session when card is ejected
        atm.setState(new IdleState(atm));
        System.out.println("Card ejected. Session terminated.");
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPIN(int pin) {
        System.out.println("PIN already entered.");
    }

    private WithdrawalHandler buildHandler() {
        VerifyBalanceHandler verifyBalance = new VerifyBalanceHandler();
        VerifyCashHandler verifyCash = new VerifyCashHandler();
        CashHandler cash = new CashHandler();
        UpdateBalanceHandler update = new UpdateBalanceHandler();

        verifyBalance.setNext(verifyCash);
        verifyCash.setNext(cash);
        cash.setNext(update);

        return verifyBalance;
    }

}

