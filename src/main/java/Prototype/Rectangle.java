package Prototype;

import java.util.Objects;

public class Rectangle extends Shape{
    private int length;
    private int breadth;

    Rectangle(){

    }

    Rectangle(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    Rectangle(Rectangle rectangle){
        this.length = rectangle.length;
        this.breadth = rectangle.breadth;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }

    @Override
    public void area() {
        System.out.println("area is " + length*breadth);
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length && breadth == rectangle.breadth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, breadth);
    }
}
