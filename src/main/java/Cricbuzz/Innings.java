package Cricbuzz;

import java.util.HashSet;
import java.util.Set;

public class Innings {
    private final Team battingTeam;
    private final Team bowlingTeam;
    private final int maxOvers;
    private int currentOvers;
    private int wicketsLost;
    private final Set<Player> dismissedBatsmen;

    public Innings(Team battingTeam, Team bowlingTeam, int maxOvers) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.maxOvers = maxOvers;
        this.currentOvers = 0;
        this.wicketsLost = 0;
        this.dismissedBatsmen = new HashSet<>();
    }

    public void incrementOver() {
        currentOvers++;
    }

    public void incrementWickets(Player batsman) {
        wicketsLost++;
        dismissedBatsmen.add(batsman);
    }

    public boolean isBatsmanOut(Player batsman) {
        return dismissedBatsmen.contains(batsman);
    }

    public boolean isOverLimitReached() {
        return currentOvers >= maxOvers;
    }

    public boolean allOut() {
        return wicketsLost >= 10;
    }

    public int getCurrentOvers() {
        return currentOvers;
    }

    public int getMaxOvers() {
        return maxOvers;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    public Set<Player> getDismissedBatsmen() {
        return dismissedBatsmen;
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }
}