package Chess;

public class Player {
    private String name;
    private PieceColor color;
    private int timeLeft;

    public Player(String name, PieceColor color, int totalTime) {
        this.name = name;
        this.color = color;
        this.timeLeft = totalTime;
    }

    public String getName() {
        return name;
    }

    public PieceColor getColor() {
        return color;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void reduceTime(int seconds) {
        timeLeft = Math.max(0, timeLeft - seconds);
    }

    public boolean hasTimeLeft() {
        return timeLeft > 0;
    }
}
