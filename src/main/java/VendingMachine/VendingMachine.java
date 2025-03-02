package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private VendingMachineState state;
    private Map<Item, Integer> inventory;
    private int balance;
    private Item selectedItem;

    VendingMachine(){
        this.state = new IdleState(this);
        this.inventory = new HashMap<>();
        this.balance = 0;
    }

    public void addStock(String item, int amount){
        try{
            Item item1 = ItemFactory.getItem(item);
            inventory.put(item1, inventory.getOrDefault(item1,0) + amount);
        } catch (Exception e){
            System.out.println("Item does not exist");
        }
    }

    public boolean reduceStock(Item item, int amount){
        if(amount <= 0){
            System.out.println("inavlid amount");
            return false;
        }
        if(inventory.getOrDefault(item,0) >= amount){
            inventory.put(item, inventory.get(item) - amount);
            return true;
        }
        return false;
    }

    public boolean hasItem(Item item){
        return inventory.getOrDefault(item,0) > 0;
    }

    public boolean hasSelectedItem(){
        return inventory.getOrDefault(selectedItem,0) > 0;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }
}
