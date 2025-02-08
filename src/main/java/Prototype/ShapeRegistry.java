package Prototype;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private final Map<ShapeType, Shape> shapeMap = new HashMap<>();

    public ShapeRegistry() {
        shapeMap.put(ShapeType.CIRCLE, new Circle(10));  // Preload with default values
        shapeMap.put(ShapeType.RECTANGLE, new Rectangle(5, 8));
        shapeMap.put(ShapeType.SQUARE, new Square(6,6));
    }

    public Shape getShape(ShapeType shapeType) {
        return shapeMap.get(shapeType).clone(); // Clone instead of creating a new object
    }
}
