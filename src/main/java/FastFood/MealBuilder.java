package FastFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MealBuilder {
    MenuItem type;
    List<Item> items;
    Float price;
    private Map<MenuItem, Item> menu;
    private String name;
    MealBuilder() {
        type = MenuItem.custom_meal;
        price = 0.0f;
        items = new ArrayList<>();
        name = "CUSTOM MEAL";
    }

    public MealBuilder fromMenu(Map<MenuItem, Item> menu) {
        this.menu = menu;
        return this;
    }

    public MealBuilder fromMenuItem(MenuItem menuItem) {

        if(menu == null)
            menu = DefaultMenu.getMenu();

        Meal meal;

        if (menu.containsKey(menuItem)) {
            meal = (Meal) menu.get(menuItem);
            this.type = menuItem;
            this.price = meal.getPrice();
            this.items.add(meal);
            this.name = meal.getName();
        } else {
            meal = new MealBuilder().build();
            this.type = menuItem.custom_meal;
            this.name = "CUSTOM MEAL";
            this.price = 0.0f;
        }

        return this;
    }

    public MealBuilder withSandwich(Sandwich sandwich) {
        items.add(sandwich);
        return this;
    }

    public MealBuilder withSide(Side sideOrder) {
        items.add(sideOrder);
        return this;
    }

    public MealBuilder withDrink(Drink drink) {
        items.add(drink);
        return this;
    }

    public MealBuilder atPrice(float price) {
        this.price = price;
        return this;
    }

    public MealBuilder withName(String mealName){
        this.name = mealName;
        return this;
    }

    public Meal build() {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Side> sides = new ArrayList<>();

        for(Item item: this.items)
            if(item instanceof Meal)
                return new Meal((Meal) item);

        for (Item item : this.items)
            if (item instanceof Sandwich)
                sandwiches.add(new Sandwich((Sandwich) item));

        for (Item item : this.items)
            if (item instanceof Drink)
                drinks.add(new Drink((Drink) item));

        for (Item item : this.items)
            if (item instanceof Side)
                sides.add(new Side((Side) item));

        Meal meal = new Meal(this.name,
                sandwiches,
                drinks,
                sides,
                this.price);

        return meal;
    }

    public MealBuilder size(ItemSize size) {
        return this;
    }
}
