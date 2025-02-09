import Flyweight.*;

public class Main {
    public static void main(String[] args){
        CircleFlyweight factory = new CircleFlyweight();

        Circle c1 = factory.getCircle(5, "Red");
        Circle c2 = factory.getCircle(10, "Blue");
        Circle c3 = factory.getCircle(5, "Red");

        System.out.println(c1 == c3);
    }
}
