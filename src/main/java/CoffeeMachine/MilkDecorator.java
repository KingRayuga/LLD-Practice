package CoffeeMachine;

public class MilkDecorator extends BeverageDecorator{
    MilkDecorator(Beverage beverage){
        super(beverage);
    }

    @Override
    public int getMilk() {
        return beverage.getMilk() + 10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Extra Milk bruv";
    }
}
