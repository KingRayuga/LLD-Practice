package Prototype;

import java.util.Objects;

public class Square extends Shape {
    private int length;
    private int breadth;

    Square(){

    }

    Square(int length, int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    Square(Square square){
        this.length = square.length;
        this.breadth = square.breadth;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square...");
    }

    @Override
    public void area() {
        System.out.println("area is " + length*breadth);
    }

    @Override
    public Shape clone() {
        return new Square(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return length == square.length && breadth == square.breadth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, breadth);
    }
}
