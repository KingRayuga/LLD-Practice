package CoffeeMachine;

public class SugarDecorator extends BeverageDecorator{

    SugarDecorator(Beverage beverage){
        super(beverage);
    }

    @Override
    public int getSugar() {
        return beverage.getSugar() + 10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Extra Sugar Bruv";
    }
}
