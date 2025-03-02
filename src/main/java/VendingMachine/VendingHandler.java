package VendingMachine;

public interface VendingHandler {
    public void setNextHandler(VendingHandler nextHandler);
    public boolean handle(VendingRequest vendingRequest);
}
