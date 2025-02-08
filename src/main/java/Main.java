import Prototype.Shape;
import Prototype.ShapeRegistry;
import Prototype.ShapeType;

public class Main {
    public static void main(String[] args){
        ShapeRegistry registry = new ShapeRegistry();

        // Fetch and clone shapes
        Shape circle1 = registry.getShape(ShapeType.CIRCLE);
        Shape circle2 = registry.getShape(ShapeType.CIRCLE);

        Shape rectangle1 = registry.getShape(ShapeType.RECTANGLE);
        Shape rectangle2 = registry.getShape(ShapeType.RECTANGLE);

        Shape square1 = registry.getShape(ShapeType.SQUARE);
        Shape square2 = registry.getShape(ShapeType.SQUARE);

        System.out.println(circle1.equals(circle2));
        System.out.println(rectangle1 == rectangle2);
        System.out.println(square1 == square2);

        circle1.draw();
        circle1.area();

        rectangle1.draw();
        rectangle1.area();

        square1.draw();
        square1.area();
    }
}
