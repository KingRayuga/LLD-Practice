package Cricbuzz;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Team {
    private final UUID uuid;
    private String teamName;
    private final List<Player> playing11;
    private final List<Player> extras;

    public Team(String teamName, List<Player> playing11, List<Player> extras) {

        uuid = UUID.randomUUID();

        if (playing11 == null || playing11.size() != 11) {
            throw new IllegalArgumentException("A team must have exactly 11 players in playing XI.");
        }
        if (extras == null || extras.size() > 5) {
            throw new IllegalArgumentException("A team can have at most 5 extra players.");
        }
        this.teamName = teamName;
        this.playing11 = Collections.unmodifiableList(playing11);
        this.extras = Collections.unmodifiableList(extras);
    }

    public List<Player> getPlaying11() {
        return playing11;
    }

    public List<Player> getExtras() {
        return extras;
    }

    public String getTeamName() {
        return teamName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}