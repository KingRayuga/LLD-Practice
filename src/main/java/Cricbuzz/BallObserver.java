package Cricbuzz;

public interface BallObserver {
    public void onBallUpdate(Player batsman, Player bowler, int runs, boolean isWicket, boolean isFour, boolean isSix, boolean isWide, boolean isNoBall);
}
