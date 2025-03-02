package VendingMachine;

public class HasMoneyState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    HasMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertMoney(int amount) {
        vendingMachine.addBalance(amount);
    }

    @Override
    public void selectItem(Item item) {
        vendingMachine.setSelectedItem(item);
        new DispensingState(vendingMachine);
    }

    @Override
    public void dispense() {
        System.out.println("Please select item first");
    }

    @Override
    public void refund() {

    }
}
