package Splitwise;

public class ExpenseCreationHandler extends ExpenseHandler{

    @Override
    public Expense handleExpense(ExpenseContext expenseContext) {

        Split split = new Split(expenseContext.getSplitType(),
                expenseContext.getTotalAmount(),
                expenseContext.getSplitAmount()
        );

        Expense expense = new Expense.Builder()
                .setSplit(split)
                .setAmount(expenseContext.getTotalAmount())
                .setDescription(expenseContext.getDescription())
                .setAddedBy(expenseContext.getAddedBy())
                .setSharer(expenseContext.getSharedWith())
                .build();

        expenseContext.setExpense(expense);

        if(nextHandler != null){
            return nextHandler.handleExpense(expenseContext);
        }

        return expense;
    }
}
