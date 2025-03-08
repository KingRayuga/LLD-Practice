package Splitwise;

public class SplitStrategyFactory {
    public static SplitStrategy getSplitStrategy(SplitType splitType){
        return switch (splitType){
            case EQUAL -> new EqualSplitStrategy();
            case AMOUNT -> new AmountSplitStrategy();
            case PERCENT -> new PercentageSplitStrategy();
        };
    }
}
