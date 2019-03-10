package shop;

import animals.Animal;
import other.Observer;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Observer {

    private List<ISellable> inventory = new ArrayList<>();

    public List<ISellable> getInventory(){
        return this.inventory;
    }

    public void addNewItem(String name, double price){
        addToInventory(new Item(name, price));
    }

    public void removeItem(Item item){
        removeFromInventory(item);
    }

    private void addToInventory(ISellable item){
        inventory.add(item);
    }

    private void removeFromInventory(ISellable item){
        inventory.remove(item);
    }

    @Override
    public void update(Object object) {
        addToInventory((Animal)object);
        removeFromInventory((Item)object);
    }
}
