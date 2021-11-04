package FastFood;

import java.util.Map;

public class DrinkBuilder {
    String name;
    DrinkType drinkType;
    ItemSize size;
    DrinkModification modification;

    Float price;
    private Map<MenuItem, Item> menu;
    private MenuItem type;

    public DrinkBuilder() {
        modification = DrinkModification.ice;
        drinkType = DrinkType.none;
        size = ItemSize.medium;
        this.price = null;
    }

    public DrinkBuilder of(DrinkType type) {
        this.drinkType = type;
        return this;
    }

    public DrinkBuilder size(ItemSize size) {
        this.size = size;
        return this;
    }

    public DrinkBuilder withModification(DrinkModification modification) {
        this.modification = modification;
        return this;
    }

    public DrinkBuilder atPrice(Float price) {
        this.price = price;
        return this;
    }

    public Drink build() {
        Guard.againstInvalidDrinkType(drinkType);
        Guard.againstInvalidSize(size);

        if(modification == null){
            modification = DrinkModification.none;
        }

        return new Drink(this.drinkType, this.size, this.modification, this.price, this.name);
    }

    public DrinkBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DrinkBuilder fromMenu(Map<MenuItem, Item> menu){
        this.menu = menu;
        return this;
    }

    public DrinkBuilder fromMenuItem(MenuItem drinkItem) {
        if (menu == null)
            menu = DefaultMenu.getMenu();

        Drink drink;

        if (menu.containsKey(drinkItem)) {
            drink = (Drink) menu.get(drinkItem);
            type = drinkItem;
            price = drink.getPrice();
            modification = drink.getModification();
            drinkType = drink.getType();
            size = drink.getSize();
        }
        else{
            throw new IllegalArgumentException("Invalid menu item requested");
        }

        return this;
    }
}
