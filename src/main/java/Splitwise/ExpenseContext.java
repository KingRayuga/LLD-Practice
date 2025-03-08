package Splitwise;

import java.util.List;

public class ExpenseContext {
    private double totalAmount;
    private SplitType splitType;
    private SplitStrategy splitStrategy;
    private List<Double> inputs;
    private User addedBy;
    private List<User> sharedWith;
    private Expense expense;
    private List<Double> splitAmount;
    private String description;

    private ExpenseContext() {}

    public User getAddedBy() {
        return addedBy;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Expense getExpense() {
        return expense;
    }

    public List<Double> getInputs() {
        return inputs;
    }

    public List<User> getSharedWith() {
        return sharedWith;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Double> getSplitAmount() {
        return splitAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public void setSplitAmount(List<Double> splitAmount) {
        this.splitAmount = splitAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private double totalAmount;
        private SplitStrategy splitStrategy;
        private List<Double> inputs;
        private User addedBy;
        private List<User> sharedWith;
        private SplitType splitType;

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setSplitStrategy(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
            return this;
        }

        public Builder setInputs(List<Double> inputs) {
            this.inputs = inputs;
            return this;
        }

        public Builder setAddedBy(User addedBy) {
            this.addedBy = addedBy;
            return this;
        }

        public Builder setSharedWith(List<User> sharedWith) {
            this.sharedWith = sharedWith;
            return this;
        }

        public Builder setSplitType(SplitType splitType){
            this.splitType = splitType;
            return this;
        }

        public ExpenseContext build() {
            ExpenseContext context = new ExpenseContext();
            context.totalAmount = this.totalAmount;
            context.splitStrategy = this.splitStrategy;
            context.inputs = this.inputs;
            context.addedBy = this.addedBy;
            context.sharedWith = this.sharedWith;
            context.splitType = this.splitType;
            return context;
        }

    }
}
