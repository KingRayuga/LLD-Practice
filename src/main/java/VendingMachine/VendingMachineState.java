package VendingMachine;

public interface VendingMachineState {
    public void insertMoney(int amount);
    public void selectItem(Item item);
    public void dispense();
    public void refund();
}
