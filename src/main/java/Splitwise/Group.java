package Splitwise;

import java.util.*;

public class Group {
    private final UUID id;
    private final String name;
    private final List<Expense> expenseList;
    private final List<User> userList;
    private final ExpenseManager expenseManager;
    private final Map<User, Map<User, Balance>> groupBalances;

    Group(String name){
        this.name = name;
        this.id = UUID.randomUUID();
        this.expenseList = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.expenseManager = ExpenseManager.getInstance();
        this.groupBalances = new HashMap<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        if (userList.contains(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        userList.add(user);
    }

    public void showAllBalances() {
        for (User lender : groupBalances.keySet()) {
            for (User borrower : groupBalances.get(lender).keySet()) {
                Balance balance = groupBalances.get(lender).get(borrower);
                if (balance.getBorrow() > 0) {
                    System.out.println(borrower.getName() + " owes " + lender.getName() + ": " + balance.getBorrow());
                }
            }
        }
    }

    public void showBalance(User user) {
        boolean hasBalance = false;
        if (groupBalances.containsKey(user)) {
            for (Map.Entry<User, Balance> entry : groupBalances.get(user).entrySet()) {
                if (entry.getValue().getLend() > 0) {
                    System.out.println(user.getName() + " is owed by " + entry.getKey().getName() + ": " + entry.getValue().getLend());
                    hasBalance = true;
                }
            }
        }

        for (User lender : groupBalances.keySet()) {
            if (groupBalances.get(lender).containsKey(user)) {
                Balance balance = groupBalances.get(lender).get(user);
                if (balance.getBorrow() > 0) {
                    System.out.println(user.getName() + " owes " + lender.getName() + ": " + balance.getBorrow());
                    hasBalance = true;
                }
            }
        }

        if (!hasBalance) {
            System.out.println(user.getName() + " has no outstanding balances.");
        }
    }

    public void addExpense(ExpenseContext context) {
        Expense expense = expenseManager.createExpense(context);
        expenseList.add(expense);
        updateBalances(context);
    }

    public void deleteExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense does not exist");
        }
        expenseList.remove(expense);
        expenseManager.deleteExpense(expense.getId());
        revertBalances(expense);
    }

    private void updateBalances(ExpenseContext context) {
        List<User> sharedWith = context.getSharedWith();
        List<Double> splitAmounts = context.getSplitAmount();
        User lender = context.getAddedBy();

        for (int i = 0; i < sharedWith.size(); i++) {
            User borrower = sharedWith.get(i);
            double amount = splitAmounts.get(i);

            groupBalances.putIfAbsent(lender, new HashMap<>());
            groupBalances.putIfAbsent(borrower, new HashMap<>());

            groupBalances.get(borrower).putIfAbsent(lender, new Balance(0, 0));
            groupBalances.get(lender).putIfAbsent(borrower, new Balance(0, 0));

            Balance borrowerBalance = groupBalances.get(borrower).get(lender);
            Balance lenderBalance = groupBalances.get(lender).get(borrower);

            borrowerBalance.setBorrow(borrowerBalance.getBorrow() + amount);
            lenderBalance.setLend(lenderBalance.getLend() + amount);
        }
    }

    private void revertBalances(Expense expense) {
        List<User> sharedWith = expense.getSharer();
        double totalAmount = expense.getAmount();
        User lender = expense.getAddedBy();
        double splitAmount = totalAmount / sharedWith.size();

        for (User borrower : sharedWith) {
            if (groupBalances.containsKey(borrower) && groupBalances.get(borrower).containsKey(lender)) {
                Balance borrowerBalance = groupBalances.get(borrower).get(lender);
                Balance lenderBalance = groupBalances.get(lender).get(borrower);

                borrowerBalance.setBorrow(borrowerBalance.getBorrow() - splitAmount);
                lenderBalance.setLend(lenderBalance.getLend() - splitAmount);

                if (borrowerBalance.getBorrow() == 0) {
                    groupBalances.get(borrower).remove(lender);
                }
                if (lenderBalance.getLend() == 0) {
                    groupBalances.get(lender).remove(borrower);
                }
            }
        }
    }
}
