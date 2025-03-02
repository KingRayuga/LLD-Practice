package VendingMachine;

public class VendingRequest {
    private final VendingMachine vendingMachine;

    VendingRequest(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }
}