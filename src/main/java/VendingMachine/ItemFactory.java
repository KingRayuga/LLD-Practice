package VendingMachine;

public class ItemFactory {
    public static Item getItem(String item){
        return switch (item.toLowerCase()){
            case "chips" -> new Chips();
            case "mixture" -> new Mixture();
            default -> throw new IllegalArgumentException("Item does not exist");
        };
    }
}
