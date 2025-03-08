package Splitwise;

public abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;

    public void setNextHandler(ExpenseHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract Expense handleExpense(ExpenseContext expenseContext);

}
