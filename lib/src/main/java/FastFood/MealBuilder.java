package FastFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
        name = null;
        this.menu = DefaultMenu.getMenu();
    }

    public MealBuilder fromMenu(Map<MenuItem, Item> menu) {
        this.menu = menu;
        return this;
    }

    public MealBuilder fromMenuItem(MenuItem menuItem) {
        Meal meal;

        if (menu.containsKey(menuItem)) {
            meal = (Meal) menu.get(menuItem);
            this.type = menuItem;
            this.price = meal.getPrice();
            this.items.add(meal);
            this.name = "";
        } else {
            meal = new MealBuilder().build();
            this.type = menuItem.custom_meal;
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

        for (Item item : this.items)
            if (item instanceof Sandwich)
                sandwiches.add((Sandwich) item);

        for (Item item : this.items)
            if (item instanceof Drink)
                drinks.add((Drink) item);

        for (Item item : this.items)
            if (item instanceof Side)
                sides.add((Side) item);

        Meal meal = new Meal(this.name + "\n",
                sandwiches,
                drinks,
                sides,
                this.price);

        return meal;
//
//        meal.setName(type.toString().replace('_', ' ').toUpperCase(Locale.ROOT));
//        return meal;
    }
}
