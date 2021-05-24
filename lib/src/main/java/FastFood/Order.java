package FastFood;

import java.util.ArrayList;
import java.util.List;

public class Order  implements Item{
    private final String customerName;
    private final List<Item> meals = new ArrayList<Item>();

    public Order(String customerName, List<Item> items){
        this.customerName = customerName;
        for(Item item: items){
            if(item instanceof Sandwich)
                this.meals.add(new Sandwich((Sandwich) item));
            else if( item instanceof Drink)
                this.meals.add(new Drink((Drink) item));
            else if( item instanceof Side)
                this.meals.add(new Side((Side) item));
        }
    }

    @Override
    public String getName() {
        return customerName;
    }

    @Override
    public Float getPrice() {
        return null;
    }

    @Override
    public String toString(){
        String order =   this.customerName + ":";
        for (Item item: meals)  {
            order += "\t" + item.toString() + "\n";
        }

        return order;
    }
}
