package VendingMachine;

public class DispensingState implements VendingMachineState{

    private final VendingMachine vendingMachine;

    DispensingState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Dispense request is already in the process");
    }

    @Override
    public void selectItem(Item item) {
        System.out.println("Dispense request is already in the process");
    }

    @Override
    public void dispense() {

        VendingRequest vendingRequest = new VendingRequest(vendingMachine);
        VendingHandler vendingHandler = createHandlerChain();

        if(vendingHandler.handle(vendingRequest)){
            System.out.println("Dispensing successful");
        }

        new IdleState(vendingMachine);

    }

    @Override
    public void refund() {
        System.out.println("Dispense request is already in the process");
    }

    private VendingHandler createHandlerChain(){
        VendingHandler balanceCheckHandler = new BalanceCheckHandler();
        VendingHandler stockCheckHandler = new StockCheckHandler();
        VendingHandler transactionHandler = new TransactionHandler();
        VendingHandler changeHandler = new ChangeHandler();
        balanceCheckHandler.setNextHandler(stockCheckHandler);
        stockCheckHandler.setNextHandler(transactionHandler);
        transactionHandler.setNextHandler(changeHandler);

        return balanceCheckHandler;
    }
}
