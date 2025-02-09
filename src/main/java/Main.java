import Strategy.*;

public class Main {
    public static void main(String[] args){
        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.swim();

        System.out.println();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.swim();

        System.out.println();

        rubberDuck.setFlyBehavior(new FlyWithWings());
        rubberDuck.setQuackBehavior(new Quack());
        System.out.println("Rubber Duck after behavior change:");
        rubberDuck.performFly();
        rubberDuck.performQuack();
    }
}
