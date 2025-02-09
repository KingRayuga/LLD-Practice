package Facade;

public class HomeTheaterFacade {
    private final Amplifier amplifier;
    private final DVDPlayer dvdPlayer;
    private final Projector projector;

    public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
        projector.on();
        projector.setInput("DVD");
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        amplifier.off();
        dvdPlayer.off();
        projector.off();
    }
}