package FastFood;

import java.util.ArrayList;
import java.util.List;

public class Meal implements Item {
    String name;
    List<Sandwich> sandwiches;
    List<Side> sides;
    List<Drink> drinks;
    Float price;

    public Meal() {
        this.sandwiches = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.name = null;
        this.price = null;
    }

    public Meal(String mealName, List<Sandwich> sandwiches, List<Drink> drinks, List<Side> sides, Float price) {
        this.name = mealName;
        this.price = price;

        this.sandwiches = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();

        for (Sandwich s : sandwiches)
            this.sandwiches.add(new Sandwich(s));

        for (Drink d : drinks)
            this.drinks.add(new Drink(d));

        for (Side s : sides)
            this.sides.add(new Side(s));
    }

    public Meal(Meal in){
        this.name = in.getName();
        this.price = in.getPrice();
        this.sandwiches = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();

        for(Sandwich sandwich: in.sandwiches){
            this.sandwiches.add(new Sandwich(sandwich));
        }

        for(Drink drink: in.drinks){
            this.drinks.add(new Drink(drink));
        }

        for(Side side: in.sides){
            this.sides.add(new Side(side));
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sandwich = new StringBuilder();
        StringBuilder side = new StringBuilder();
        StringBuilder drink = new StringBuilder();

        if (this.sandwiches.size() > 0)
            for (Sandwich s : this.sandwiches)
                sandwich.append(s.toString());

        if (this.sides.size() > 0)
            for (Side s : this.sides)
                side.append(s.toString());

        if (this.drinks.size() > 0)
            for (Drink d : this.drinks)
                drink.append(d.toString());

        return getName()
                + "\n\t"
                + sandwich.toString()
                + "\n\t"
                + side.toString()
                + "\n\t"
                + drink.toString()
                + "\n\t"
                + price;
    }
}
