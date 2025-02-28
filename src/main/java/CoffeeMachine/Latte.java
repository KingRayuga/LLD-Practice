package CoffeeMachine;

public class Latte implements Beverage{

    @Override
    public String getDescription() {
        return "latte";
    }

    @Override
    public int getMilk() {
        return 20;
    }

    @Override
    public int getSugar() {
        return 0;
    }

    @Override
    public int getWater() {
        return 20;
    }

    @Override
    public int getCoffee() {
        return 10;
    }
}
