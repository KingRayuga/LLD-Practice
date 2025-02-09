package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CircleFlyweight {
    private final Map<String, Circle> hashMap = new HashMap<>();

    public Circle getCircle(int radius, String color){
        String key = color + radius;
        if(hashMap.containsKey(key)){
            return hashMap.get(key);
        }
        Circle circle= new Circle(radius, color);
        hashMap.put(key, circle);
        return circle;
    }
}
