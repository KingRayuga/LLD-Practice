package Cricbuzz;

public enum MatchType {
    T20(90,-1),
    ODI(50,10),
    TEST(20,4);

    private final int totalOver;
    private final int maxOverPerBowler;

    MatchType(int totalOver, int maxOverPerBowler){
        this.totalOver = totalOver;
        this.maxOverPerBowler = maxOverPerBowler;
    }

    public int getMaxOverPerBowler() {
        return maxOverPerBowler;
    }

    public int getTotalOver() {
        return totalOver;
    }
}
