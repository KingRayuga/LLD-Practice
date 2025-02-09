package Facade;

public class Amplifier {
    void on() {
        System.out.println("Amplifier is on");
    }

    void off() {
        System.out.println("Amplifier is off");
    }

    void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
}