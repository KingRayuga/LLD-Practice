package Splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ExpenseManager {
    private final Map<UUID, Expense> expenses = new HashMap<>();

    private ExpenseManager() {
    }

    private static class ExpenseManagerHolder {
        private static final ExpenseManager INSTANCE = new ExpenseManager();
    }

    public static ExpenseManager getInstance() {
        return ExpenseManagerHolder.INSTANCE;
    }

    public Expense createExpense(ExpenseContext context) {
        Expense expense = createHandler().handleExpense(context);
        expenses.put(expense.getId(), expense);
        return expense;
    }

    private ExpenseHandler createHandler() {
        ValidateHandler validateHandler = new ValidateHandler();
        ExpenseCreationHandler expenseCreationHandler = new ExpenseCreationHandler();
        BalanceHandler balanceHandler = new BalanceHandler();
        NotificationHandler notificationHandler = new NotificationHandler();

        validateHandler.setNextHandler(expenseCreationHandler);
        expenseCreationHandler.setNextHandler(balanceHandler);
        balanceHandler.setNextHandler(notificationHandler);

        return validateHandler;
    }

    public void deleteExpense(UUID expenseId) {
        if (!expenses.containsKey(expenseId)) {
            throw new IllegalArgumentException("Expense with ID " + expenseId + " does not exist.");
        }
        expenses.remove(expenseId);
    }
}
