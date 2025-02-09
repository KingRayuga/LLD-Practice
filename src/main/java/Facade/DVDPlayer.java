package Facade;

public class DVDPlayer {
    void on() {
        System.out.println("DVD Player is on");
    }

    void off() {
        System.out.println("DVD Player is off");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}