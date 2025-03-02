package VendingMachine;

public class StockCheckHandler implements VendingHandler{
    private VendingHandler next;

    @Override
    public void setNextHandler(VendingHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public boolean handle(VendingRequest vendingRequest) {
        if(!vendingRequest.getVendingMachine().hasSelectedItem()){
            return false;
        }

        if(next != null){
            return next.handle(vendingRequest);
        }

        return true;
    }
}
