package Splitwise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Double> split(double totalAmount, List<Double> inputs) throws IllegalArgumentException{
        int numberOfSplits = inputs.size();

        if(numberOfSplits == 0){
            throw new IllegalArgumentException("Cannot split an empty list");
        }

        double splitAmount = totalAmount / numberOfSplits;

        return new ArrayList<>(Collections.nCopies(numberOfSplits, splitAmount));
    }
}
