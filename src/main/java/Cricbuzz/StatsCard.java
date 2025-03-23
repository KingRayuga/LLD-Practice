package Cricbuzz;

import java.lang.reflect.Field;

public class StatsCard implements BallObserver{
    private int totalRuns;
    private int maxRuns;
    private double battingAverage;
    private int totalBallsFaced;
    private int fours;
    private int sixes;
    private int centuries;
    private int halfCenturies;
    private int totalBallsBowled;
    private double bowlingAverage;
    private int totalMaidens;
    private int totalWickets;
    private int totalNoBalls;
    private int totalWides;

    @Override
    public void onBallUpdate(Player batsman, Player bowler, int runs, boolean isWicket,
                             boolean isFour, boolean isSix, boolean isWide, boolean isNoBall) {

        if (batsman != null) {
            updateBattingStats(runs, isFour, isSix);
        }

        if (bowler != null) {
            updateBowlingStats(1, isWicket ? 1 : 0, isWide || isNoBall);
        }
    }

    public void updateBattingStats(int runs, boolean isFour, boolean isSix) {
        totalRuns += runs;
        totalBallsFaced++;
        if (runs > maxRuns) {
            maxRuns = runs;
        }
        if (isFour) {
            fours++;
        }
        if (isSix) {
            sixes++;
        }
        if (totalRuns >= 100) {
            centuries++;
        } else if (totalRuns >= 50) {
            halfCenturies++;
        }
        calculateBattingAverage();
    }

    public void updateBowlingStats(int ballsBowled, int wickets, boolean isMaiden) {
        totalBallsBowled += ballsBowled;
        totalWickets += wickets;
        if (isMaiden) {
            totalMaidens++;
        }
        calculateBowlingAverage();
    }

    private void calculateBattingAverage() {
        if (totalBallsFaced > 0) {
            battingAverage = (double) totalRuns / totalBallsFaced;
        }
    }

    private void calculateBowlingAverage() {
        if (totalWickets > 0) {
            bowlingAverage = (double) totalBallsBowled / totalWickets;
        }
    }

    public void addNoBall() {
        totalNoBalls++;
    }

    public void addWideBall() {
        totalWides++;
    }

    public void resetStats() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.setInt(this, 0);
                } else if (field.getType() == double.class) {
                    field.setDouble(this, 0.0);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to reset stats", e);
        }
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public double getBowlingAverage() {
        return bowlingAverage;
    }

    public int getCenturies() {
        return centuries;
    }

    public int getFours() {
        return fours;
    }

    public int getHalfCenturies() {
        return halfCenturies;
    }

    public int getMaxRuns() {
        return maxRuns;
    }

    public int getSixes() {
        return sixes;
    }

    public int getTotalBallsBowled() {
        return totalBallsBowled;
    }

    public int getTotalBallsFaced() {
        return totalBallsFaced;
    }

    public int getTotalMaidens() {
        return totalMaidens;
    }

    public int getTotalNoBalls() {
        return totalNoBalls;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public int getTotalWides() {
        return totalWides;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public void setBowlingAverage(double bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }

    public void setCenturies(int centuries) {
        this.centuries = centuries;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public void setHalfCenturies(int halfCenturies) {
        this.halfCenturies = halfCenturies;
    }

    public void setMaxRuns(int maxRuns) {
        this.maxRuns = maxRuns;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public void setTotalBallsBowled(int totalBallsBowled) {
        this.totalBallsBowled = totalBallsBowled;
    }

    public void setTotalBallsFaced(int totalBallsFaced) {
        this.totalBallsFaced = totalBallsFaced;
    }

    public void setTotalMaidens(int totalMaidens) {
        this.totalMaidens = totalMaidens;
    }

    public void setTotalNoBalls(int totalNoBalls) {
        this.totalNoBalls = totalNoBalls;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public void setTotalWides(int totalWides) {
        this.totalWides = totalWides;
    }
}
