package FastFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sandwich implements Item {
    String name;
    SandwichWrapping wrapping;
    List<Protein> proteins;
    List<Condiment> condiments;
    List<Topping> toppings;
    Float price;

    Sandwich() {
        name = "";
        proteins = new ArrayList<>();
        condiments = new ArrayList<>();
        toppings = new ArrayList<>();
        price = null;
    }

    Sandwich(SandwichWrapping wrapping, List<Protein> proteins, List<Topping> toppings, List<Condiment> condiments, Float price, String name) {
        this.proteins = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.toppings = new ArrayList<>();

        this.wrapping = wrapping;

        for (Protein p : proteins)
            this.proteins.add(p);

        for (Topping t : toppings)
            this.toppings.add(t);

        for (Condiment c : condiments)
            this.condiments.add(c);

        this.price = price;
        this.name = name;

    }

    Sandwich(Sandwich in) {
        this.proteins = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.toppings = new ArrayList<>();

        for (Protein protein : in.proteins) {
            proteins.add(protein);
        }

        for (Condiment condiment : in.condiments) {
            condiments.add(condiment);
        }

        for (Topping topping : in.toppings) {
            toppings.add(topping);
        }

        name = in.getName();
        wrapping = in.wrapping;
        price = in.price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder protein = new StringBuilder();
        StringBuilder topping = new StringBuilder();
        StringBuilder condiment = new StringBuilder();

        for (Protein p : this.proteins) {
            protein.append(protein.length() > 0 ? ", " : "");
            protein.append(p.toString().toUpperCase(Locale.ROOT).replace('_', ' '));
        }

        protein.append(" ON " + this.wrapping.toString().toUpperCase(Locale.ROOT).replace('_', ' '));


        if (toppings.size() > 0)
            topping.append("TOPPED WITH\n\t\t");

        for (Topping t : this.toppings) {
            topping.append(t.toString().toUpperCase(Locale.ROOT).replace('_', ' ') + ", ");
        }

        if (condiments.size() > 0)
            condiment.append("WITH \n\t\t");

        for (Condiment c : this.condiments) {
            condiment.append(c.toString().toUpperCase(Locale.ROOT).replace('_', ' ') + ", ");
        }

        return getName()
                + "\n\t"
                + protein
                + (topping.length() > 2 ? topping.substring(0, topping.length()-2) : topping)
                + (condiment.length() > 2 ? condiment.substring(0, condiment.length()-2) : condiment)
                + (price == null ? "" : price);
    }
}
