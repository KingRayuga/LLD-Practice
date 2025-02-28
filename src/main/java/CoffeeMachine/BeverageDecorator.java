package CoffeeMachine;

public abstract class BeverageDecorator implements Beverage{

    protected Beverage beverage;

    BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public int getWater() {
        return beverage.getWater();
    }

    @Override
    public int getSugar() {
        return beverage.getSugar();
    }

    @Override
    public int getCoffee() {
        return beverage.getCoffee();
    }

    @Override
    public int getMilk() {
        return beverage.getMilk();
    }
}
