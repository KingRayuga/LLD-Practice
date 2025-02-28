package CoffeeMachine;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {
    private final InventoryManagement inventory;

    CoffeeMachine(InventoryManagement inventory){
        this.inventory = inventory;
        this.inventory.addObserver(new Screen());
    }

    public boolean prepareBeverage(Beverage beverage){
        Map<Ingredients, Integer> hashMap = new HashMap<>();
        hashMap.put(Ingredients.COFFEE, beverage.getCoffee());
        hashMap.put(Ingredients.WATER, beverage.getWater());
        hashMap.put(Ingredients.MILK, beverage.getMilk());
        hashMap.put(Ingredients.SUGAR, beverage.getSugar());

        for(Map.Entry<Ingredients, Integer> entry: hashMap.entrySet()){
            if(!this.inventory.hasEnough(entry.getKey(), entry.getValue())) {
                return false;
            }
        }

        hashMap.forEach(this.inventory::consume);

        System.out.println(beverage.getDescription());

        return true;

    }

}
