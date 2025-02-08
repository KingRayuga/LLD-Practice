package Prototype;

import java.util.Objects;

public class Circle extends Shape{

    private int radius;

    Circle(){

    }

    Circle(int radius){
        this.radius = radius;
    }

    Circle(Circle circle){
        this.radius = circle.radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }

    @Override
    public void area() {
        double area = (double) 22/7;
        area *= radius*radius;
        System.out.println("area is " + area);
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }
}
