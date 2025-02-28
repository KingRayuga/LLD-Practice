package CoffeeMachine;

public class Screen implements Observer{
    @Override
    public void update(String Message) {
        System.out.println("SCREEN ALERT: " + Message);
    }
}
