package CoffeeMachine;

import java.util.HashMap;

public class InventoryManagement extends Observable{

    private static class InventoryManagementHelper{
        static final InventoryManagement INSTANCE = new InventoryManagement();
    }

    public InventoryManagement getInstance(){
        return InventoryManagementHelper.INSTANCE;
    }

    private final HashMap<Ingredients, Integer> stock = new HashMap<>();

    InventoryManagement(){
        for(Ingredients ingredients: Ingredients.values()){
            stock.put(ingredients, 1000);
        }
    }

    public boolean consume(Ingredients ingredients, int amount){
        if(!hasEnough(ingredients, amount)){
            return false;
        }

        stock.put(ingredients, stock.getOrDefault(ingredients,0) - amount);

        if(stock.getOrDefault(ingredients, 0) <= 50){
            notifyObserver("Item is running low " + ingredients.name());
        }

        return true;
    }

    public void refill(Ingredients ingredients, int amount){
        stock.put(ingredients, stock.getOrDefault(ingredients,0) + amount);
        notifyObserver("Refill done " + ingredients.name() + " " + amount);
    }

    public boolean hasEnough(Ingredients ingredients, int amount){
        if(stock.getOrDefault(ingredients,0) < amount){
            notifyObserver("Item is out of Stock " + ingredients.name());
            return false;
        }
        return true;
    }
}

