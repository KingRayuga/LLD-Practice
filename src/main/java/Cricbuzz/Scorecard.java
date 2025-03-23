package Cricbuzz;

import java.util.HashMap;
import java.util.Map;

public class Scorecard implements BallObserver{
    private final Map<Player, Integer> runsScored;
    private final Map<Player, Integer> ballsFaced;
    private final Map<Player, Integer> fours;
    private final Map<Player, Integer> sixes;
    private final Map<Player, Integer> wicketsTaken;
    private final Map<Player, Integer> ballsBowled;
    private final Map<Player, Integer> wides;
    private final Map<Player, Integer> noBalls;
    private int totalRuns;
    private int totalWickets;
    private int totalBalls;

    public Scorecard() {
        this.runsScored = new HashMap<>();
        this.ballsFaced = new HashMap<>();
        this.fours = new HashMap<>();
        this.sixes = new HashMap<>();
        this.wicketsTaken = new HashMap<>();
        this.ballsBowled = new HashMap<>();
        this.wides = new HashMap<>();
        this.noBalls = new HashMap<>();
        this.totalRuns = 0;
        this.totalWickets = 0;
        this.totalBalls = 0;
    }

    @Override
    public void onBallUpdate(Player batsman, Player bowler, int runs, boolean isWicket,
                             boolean isFour, boolean isSix, boolean isWide, boolean isNoBall) {

        // Update Batting Stats
        if (batsman != null) {
            updateBattingStats(batsman, runs);
        }

        // Update Bowling Stats
        if (bowler != null) {
            updateBowlingStats(bowler, isWicket, isWide, isNoBall);
        }
    }

    public void updateBattingStats(Player player, int runs) {
        runsScored.put(player, runsScored.getOrDefault(player, 0) + runs);
        ballsFaced.put(player, ballsFaced.getOrDefault(player, 0) + 1);

        if (runs == 4) {
            fours.put(player, fours.getOrDefault(player, 0) + 1);
        } else if (runs == 6) {
            sixes.put(player, sixes.getOrDefault(player, 0) + 1);
        }

        totalRuns += runs;
        totalBalls++;
    }

    public void updateBowlingStats(Player player, boolean isWicket, boolean isWide, boolean isNoBall) {
        ballsBowled.put(player, ballsBowled.getOrDefault(player, 0) + 1);

        if (isWicket) {
            wicketsTaken.put(player, wicketsTaken.getOrDefault(player, 0) + 1);
            totalWickets++;
        }

        if (isWide) {
            wides.put(player, wides.getOrDefault(player, 0) + 1);
            totalRuns++; // Wide ball adds a run
        }

        if (isNoBall) {
            noBalls.put(player, noBalls.getOrDefault(player, 0) + 1);
            totalRuns++; // No-ball adds a run
        }
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public Map<Player, Integer> getRunsScored() {
        return runsScored;
    }

    public Map<Player, Integer> getBallsFaced() {
        return ballsFaced;
    }

    public Map<Player, Integer> getFours() {
        return fours;
    }

    public Map<Player, Integer> getSixes() {
        return sixes;
    }

    public Map<Player, Integer> getWicketsTaken() {
        return wicketsTaken;
    }

    public Map<Player, Integer> getBallsBowled() {
        return ballsBowled;
    }
}
