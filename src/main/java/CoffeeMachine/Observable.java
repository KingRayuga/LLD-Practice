package CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
       observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(String message){
        for(Observer observer: observers){
            observer.update(message);
        }
    }
}
