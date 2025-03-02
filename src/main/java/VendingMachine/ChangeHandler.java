package VendingMachine;

public class ChangeHandler implements VendingHandler{
    private VendingHandler next;

    @Override
    public void setNextHandler(VendingHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public boolean handle(VendingRequest vendingRequest) {
        System.out.println("giving out the change " + vendingRequest.getVendingMachine().getBalance());
        vendingRequest.getVendingMachine().setBalance(0);
        return true;
    }
}
