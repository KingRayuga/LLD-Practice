package Splitwise;

import java.util.List;

public class ValidateHandler extends ExpenseHandler {

    @Override
    public Expense handleExpense(ExpenseContext expenseContext) {
        SplitStrategy splitStrategy = expenseContext.getSplitStrategy();
        try {
            List<Double> splitAmount = splitStrategy.split(expenseContext.getTotalAmount(), expenseContext.getInputs());
            if (Double.compare(0.0, expenseContext.getTotalAmount()) == 1) {
                throw new IllegalArgumentException("Total amount must be greater than 0");
            }
            if (expenseContext.getAddedBy() == null) {
                throw new IllegalArgumentException("User cannot be null!");
            }
            if (splitAmount == null || expenseContext.getSharedWith() == null || splitAmount.isEmpty()) {
                throw new IllegalArgumentException("Invalid inputs!");
            }
            if (splitAmount.size() != expenseContext.getSharedWith().size()) {
                throw new IllegalArgumentException("Number of splits doesn't match number of users!");
            }

            expenseContext.setSplitAmount(splitAmount);

            if (nextHandler != null) {
                return nextHandler.handleExpense(expenseContext);
            }

            return null;

        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
