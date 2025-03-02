package VendingMachine;

public class IdleState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        vendingMachine.setBalance(amount);
        new HasMoneyState(vendingMachine);
    }

    @Override
    public void selectItem(Item item) {
        System.out.println("Please enter amount first");
    }

    @Override
    public void dispense() {
        System.out.println("Please enter amount first");
    }

    @Override
    public void refund() {
        System.out.println("Please enter amount first");
    }
}
