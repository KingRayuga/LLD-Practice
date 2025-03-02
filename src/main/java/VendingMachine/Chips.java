package VendingMachine;

public class Chips implements Item{
    @Override
    public int getPrice() {
        return 30;
    }

    @Override
    public String getName() {
        return "Chips";
    }
}
