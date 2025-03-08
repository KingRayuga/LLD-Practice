package Splitwise;

import java.util.List;

public class Split {
    private final SplitType type;
    private final double amount;
    private final List<Double> splitList;

    public Split(SplitType type, double amount, List<Double> list) {

        if(list == null){
            throw new IllegalArgumentException("List cannot be null");
        }

        this.type = type;
        this.amount = amount;
        this.splitList = list;
    }

    public double getAmount() {
        return amount;
    }

    public SplitType getType() {
        return type;
    }

    public List<Double> getSplitList() {
        return splitList;
    }
}
