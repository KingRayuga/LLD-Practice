package Splitwise;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BalanceHandler extends ExpenseHandler{

    @Override
    public Expense handleExpense(ExpenseContext expenseContext) {
        List<User> users = expenseContext.getSharedWith();
        List<Double> amounts = expenseContext.getSplitAmount();
        double totalAmount = expenseContext.getTotalAmount();
        User payer = expenseContext.getAddedBy();

        for(int i=0; i<users.size(); i++){
            User user = users.get(i);
            double amount = amounts.get(i);
            if(user.equals(payer)){
                amount = totalAmount - amount;
                user.setTotalLend(user.getTotalLend() + amount);
                Map<UUID, Balance> balanceSheet = user.getBalances();
                for(int j=0;j<users.size();j++){
                    if(i==j){
                        continue;
                    }
                    User sharedWith = users.get(j);
                    double owed = amounts.get(j);

                    Balance balance = balanceSheet.getOrDefault(sharedWith.getId(), new Balance(0, 0));
                    balance.setLend(balance.getLend() + owed);
                    balanceSheet.put(sharedWith.getId(), balance);

                    Map<UUID, Balance> sharedWithBalances = sharedWith.getBalances();
                    balance = sharedWithBalances.getOrDefault(user.getId(), new Balance(0, 0));
                    balance.setBorrow(balance.getBorrow() + owed);
                    sharedWithBalances.put(user.getId(), balance);
                }
            } else {
                user.setTotalBorrow(user.getTotalBorrow() + amount);
            }
        }

        if(nextHandler != null){
            return nextHandler.handleExpense(expenseContext);
        }

        return expenseContext.getExpense();
    }
}
