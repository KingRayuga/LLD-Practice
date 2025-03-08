package Splitwise;

import java.util.List;
import java.util.UUID;

public class Expense {
    private final UUID id;
    private String description;
    private User addedBy;
    private List<User> sharer;
    private double amount;
    private Split split;

    private Expense(){
        this.id = UUID.randomUUID();
    }

    public double getAmount() {
        return amount;
    }

    public UUID getId() {
        return id;
    }

    public List<User> getSharer() {
        return sharer;
    }

    public String getDescription() {
        return description;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public static class Builder {
        private String description;
        private User addedBy;
        private List<User> sharer;
        private double amount;
        private Split split;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAddedBy(User addedBy) {
            this.addedBy = addedBy;
            return this;
        }

        public Builder setSharer(List<User> sharer) {
            this.sharer = sharer;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setSplit(Split split) {
            this.split = split;
            return this;
        }

        public Expense build() {
            Expense expense = new Expense();
            expense.description = this.description;
            expense.addedBy = this.addedBy;
            expense.sharer = this.sharer;
            expense.amount = this.amount;
            expense.split = this.split;
            return expense;
        }
    }
}
