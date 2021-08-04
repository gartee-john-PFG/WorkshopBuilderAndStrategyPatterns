package FastFood;

import java.util.ArrayList;
import java.util.List;

public class Order  implements Item{
    private final String customerName;
    private final List<Item> meals = new ArrayList<Item>();
    private Float price;
    public Order(String customerName, List<Item> items){
        this.customerName = customerName;
        this.price = 0.0f;
        for(Item item: items){
            if(item instanceof Sandwich)
                this.meals.add(new Sandwich((Sandwich) item));
            else if( item instanceof Drink)
                this.meals.add(new Drink((Drink) item));
            else if( item instanceof Side)
                this.meals.add(new Side((Side) item));
            else if( item instanceof Meal)
                this.meals.add(new Meal((Meal) item));
        }
    }

    @Override
    public String getName() {
        return customerName;
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String toString(){
        String order =   this.customerName + ":";
        for (Item item: meals)  {
            order += "\n\t" + item.toString();
            price += item.getPrice() == null ? 0.0f : item.getPrice();
        }

        return order + "\n" + this.price.toString();
    }

    public String getOrderText() {
        StringBuilder result = new StringBuilder();

        for(Item mealItem: meals){
            result.append(mealItem.getName());
        }

        return result.toString();
    }
}
