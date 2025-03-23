package Cricbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MatchManager {
    private final Map<UUID, Match> matches;

    private MatchManager() {
        this.matches = new HashMap<>();
    }

    private static class Holder {
        private static final MatchManager INSTANCE = new MatchManager();
    }

    public static MatchManager getInstance() {
        return Holder.INSTANCE;
    }

    public void createMatch(MatchType matchType, Team team1, Team team2) {
        Match match = new Match(matchType, team1, team2);
        matches.put(match.getUuid(), match);
    }

    public Match getMatch(UUID matchId) {
        if (!matches.containsKey(matchId)) {
            throw new IllegalArgumentException("Match ID not found.");
        }
        return matches.get(matchId);
    }

    public void updateBall(UUID matchId, Player batsman, Player bowler, int runs,
                           boolean isWicket, boolean isFour, boolean isSix,
                           boolean isWide, boolean isNoBall) {
        Match match = getMatch(matchId);
        match.onBallUpdate(batsman, bowler, runs, isWicket, isFour, isSix, isWide, isNoBall);
    }

    public void endMatch(UUID matchId) {
        matches.remove(matchId);
        System.out.println("Match " + matchId + " has ended and removed from records.");
    }
}