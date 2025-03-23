package Cricbuzz;

public class Player {
    private final Person person;
    private PlayerType playerType;
    private final StatsCard statsCard;

    Player(Person person, PlayerType playerType, StatsCard statsCard){
        this.person = person;
        this.playerType = playerType;
        this.statsCard = statsCard;
    }

    public Person getPerson() {
        return person;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public StatsCard getStatsCard() {
        return statsCard;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
