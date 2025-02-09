package Facade;

public class Projector {
    void on() {
        System.out.println("Projector is on");
    }

    void off() {
        System.out.println("Projector is off");
    }

    void setInput(String input) {
        System.out.println("Projector input set to " + input);
    }
}