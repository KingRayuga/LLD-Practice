package Splitwise;

import java.util.List;

public class AmountSplitStrategy implements SplitStrategy{

    @Override
    public List<Double> split(double totalAmount, List<Double> inputs) throws IllegalArgumentException{
        double totalShares = inputs.stream().reduce(0.0, Double::sum);

        if(totalShares != totalAmount){
            throw new IllegalArgumentException(
                    "The total amount of shares must be equal to the total amount of inputs");
        }

        return inputs;
    }
}
