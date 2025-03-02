package VendingMachine;

public class Mixture implements Item{
    @Override
    public String getName() {
        return "Mixture";
    }

    @Override
    public int getPrice() {
        return 50;
    }
}
