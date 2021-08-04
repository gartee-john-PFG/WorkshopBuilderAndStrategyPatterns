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

    private String buildDescription() {
        StringBuilder result = new StringBuilder();
        long protienCount = proteins.stream().count();

        if (protienCount == 0l) {
            result.append("VEGGIE");
        } else if (protienCount == 1l) {
            result.append("SINGLE " + proteins.get(0).toString().toUpperCase(Locale.ROOT));
        } else if (protienCount == 2l) {
            result.append("DOUBLE");
        } else if (protienCount == 3l) {
            result.append("TRIPLE");
        } else if (protienCount == 4l) {
            result.append("QUAD");
        } else {
            result.append("BIG " + String.valueOf(protienCount));
        }

        switch (this.wrapping) {
            case bun:
                result.append(" ON " + this.wrapping.toString().toUpperCase(Locale.ROOT));
                break;
        }

        StringBuilder toppingsAndCondiments = new StringBuilder();

        for (Topping topping : toppings) {
            toppingsAndCondiments.append(topping.toString().toUpperCase(Locale.ROOT) + ", " );
        }

        for (Condiment condiment : condiments) {
            toppingsAndCondiments.append(condiment.toString().toUpperCase(Locale.ROOT) + ", ");
        }

        if(toppingsAndCondiments.length() > 0)
            toppingsAndCondiments = toppingsAndCondiments.delete(toppingsAndCondiments.length() - 2, toppingsAndCondiments.length());

        if( toppings.stream().count() + condiments.stream().count() > 1){
            int lastComma = toppingsAndCondiments.lastIndexOf(", ");
            toppingsAndCondiments.replace(lastComma, lastComma + 2, ", AND ");
        }

        return toppingsAndCondiments.length() == 0 ? result.toString() :
                result.append(" WITH " + toppingsAndCondiments.toString()).toString();
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + (getName().length() == 0 ? "" : "\n\t")
                + buildDescription()
                + (price == null ? "" : "\n\t" + price);
    }
}
