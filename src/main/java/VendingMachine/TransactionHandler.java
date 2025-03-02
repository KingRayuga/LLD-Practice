package VendingMachine;

public class TransactionHandler implements VendingHandler{

    private VendingHandler next;

    @Override
    public void setNextHandler(VendingHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public boolean handle(VendingRequest vendingRequest) {
        System.out.println("Dispensing Item");
        int balance = vendingRequest.getVendingMachine().getBalance();
        int cost = vendingRequest.getVendingMachine().getSelectedItem().getPrice();
        vendingRequest.getVendingMachine().setBalance(balance - cost);
        vendingRequest.getVendingMachine().reduceStock(vendingRequest.getVendingMachine().getSelectedItem(), 1);
        vendingRequest.getVendingMachine().setSelectedItem(null);

        if(next != null){
            return next.handle(vendingRequest);
        }
        return true;
    }
}
