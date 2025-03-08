package Splitwise;

import java.util.List;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy {

    private static final double PERCENTAGE_LIMIT = 100.0;
    private static final double PERCENTAGE_EPSILON = 0.000001;

    @Override
    public List<Double> split(double totalAmount, List<Double> inputs) throws IllegalArgumentException{
        double totalPercentage = inputs.stream().reduce(0.0, Double::sum);

        if(Math.abs(totalPercentage - PERCENTAGE_LIMIT) > PERCENTAGE_EPSILON){
            throw new IllegalArgumentException(
                    "The total percentage of inputs must be equal to 100%");
        }

        return inputs;
    }
}
