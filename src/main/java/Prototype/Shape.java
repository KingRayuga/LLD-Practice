package Prototype;

public abstract class Shape implements Cloneable{

    public abstract void draw();

    public abstract void area();

    @Override
    public abstract Shape clone();

    @Override
    public abstract boolean equals(Object obj);
}
