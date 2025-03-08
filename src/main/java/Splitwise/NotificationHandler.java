package Splitwise;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationHandler extends ExpenseHandler {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public Expense handleExpense(ExpenseContext expenseContext) {
        List<User> users = expenseContext.getExpense().getSharer();
        List<Double> splitAmount = expenseContext.getSplitAmount();
        double totalAmount = expenseContext.getTotalAmount();
        User payer = expenseContext.getAddedBy();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            double amount = splitAmount.get(i);

            if (user.equals(payer)) {
                amount = totalAmount - amount;
            } else {
                amount = -amount;
            }

            final double finalAmount = amount;

            executorService.submit(() -> user.notifications(finalAmount));
        }

        if(nextHandler != null){
            return nextHandler.handleExpense(expenseContext);
        }

        return expenseContext.getExpense();
    }
}
