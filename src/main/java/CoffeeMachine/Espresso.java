package CoffeeMachine;

public class Espresso implements Beverage{
    @Override
    public int getWater() {
        return 30;
    }

    @Override
    public int getCoffee() {
        return 10;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public int getSugar() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
