package Splitwise;

import java.util.List;

public interface SplitStrategy {
    public List<Double> split(double totalAmount, List<Double> inputs) throws IllegalArgumentException;
}
