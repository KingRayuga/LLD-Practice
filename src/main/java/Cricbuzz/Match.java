package Cricbuzz;

import java.util.*;

public class Match {
    private final UUID uuid;
    private final MatchType matchType;
    private final Team team1;
    private final Team team2;
    private final Scorecard scorecard;
    private final List<BallObserver> observers;
    private Innings firstInnings;
    private Innings secondInnings;
    private boolean isSecondInnings;
    private final Map<Player, Integer> bowlerOverCount;
    private Player lastBowler;

    public Match(MatchType matchType, Team team1, Team team2) {

        uuid = UUID.randomUUID();

        this.matchType = matchType;
        this.team1 = team1;
        this.team2 = team2;
        this.scorecard = new Scorecard();
        this.observers = new ArrayList<>();
        this.observers.add(scorecard);
        this.isSecondInnings = false;
        this.lastBowler = null;
        this.bowlerOverCount = new HashMap<>();

        this.firstInnings = new Innings(team1, team2, matchType.getTotalOver());
    }

    public void startSecondInnings() {
        if (!isSecondInnings) {
            isSecondInnings = true;
            this.secondInnings = new Innings(team2, team1, matchType.getTotalOver());
        } else {
            throw new IllegalStateException("Second innings has already started.");
        }
    }

    public void onBallUpdate(Player batsman, Player bowler, int runs, boolean isWicket,
                             boolean isFour, boolean isSix, boolean isWide, boolean isNoBall) {

        Innings currentInnings = isSecondInnings ? secondInnings : firstInnings;

        if (lastBowler != null && lastBowler.equals(bowler)) {
            throw new IllegalStateException("A bowler cannot bowl consecutive overs.");
        }

        int maxOverPerBowler = matchType.getMaxOverPerBowler();
        bowlerOverCount.put(bowler, bowlerOverCount.getOrDefault(bowler, 0) + 1);
        if (maxOverPerBowler != -1 && bowlerOverCount.get(bowler) > maxOverPerBowler) {
            throw new IllegalStateException("Bowler has exceeded max overs allowed.");
        }

        lastBowler = bowler;

        if (isWicket && currentInnings.isBatsmanOut(batsman)) {
            throw new IllegalStateException("Batsman is already out.");
        }

        for (BallObserver observer : observers) {
            observer.onBallUpdate(batsman, bowler, runs, isWicket, isFour, isSix, isWide, isNoBall);
        }

        if (currentInnings.isOverLimitReached() || currentInnings.allOut()) {
            if (!isSecondInnings) {
                startSecondInnings();
            } else {
                System.out.println("Match Over!");
            }
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public Innings getFirstInnings() {
        return firstInnings;
    }

    public Innings getSecondInnings() {
        return secondInnings;
    }

    public List<BallObserver> getObservers() {
        return observers;
    }

    public Map<Player, Integer> getBowlerOverCount() {
        return bowlerOverCount;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public Player getLastBowler() {
        return lastBowler;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
}