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
        this.proteins.addAll(proteins);
        this.toppings.addAll(toppings);
        this.condiments.addAll(condiments);
        this.price = price;
        this.name = name;

    }

    Sandwich(Sandwich in) {
        this.proteins = new ArrayList<>();
        this.condiments = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.proteins.addAll(in.proteins);
        this.condiments.addAll(in.condiments);
        this.toppings.addAll(in.toppings);
        name = in.getName();
        wrapping = in.wrapping;
        price = in.price;
    }

    @Override
    public String getName() {
        return name;
    }

    private String buildDescription() {
        StringBuilder result = buildBasicSandwichDescription();
        StringBuilder toppingsAndCondiments = buildToppingAndCondimentDescription();

        return combineSandwichToppingsAndCondimentsDescription(result, toppingsAndCondiments);
    }

    private String combineSandwichToppingsAndCondimentsDescription(StringBuilder result, StringBuilder toppingsAndCondiments) {
        return toppingsAndCondiments.length() == 0 ? result.toString() :
                result.append(" WITH ").append(toppingsAndCondiments).toString();
    }

    private StringBuilder buildToppingAndCondimentDescription() {
        StringBuilder toppingsAndCondiments = new StringBuilder();

        for (Topping topping : toppings) {
            toppingsAndCondiments.append(topping.toString().toUpperCase(Locale.ROOT)).append(", ");
        }

        for (Condiment condiment : condiments) {
            toppingsAndCondiments.append(condiment.toString().toUpperCase(Locale.ROOT)).append(", ");
        }

        if (toppingsAndCondiments.length() > 0) {
            toppingsAndCondiments.delete(toppingsAndCondiments.length() - 2, toppingsAndCondiments.length());
        }

        if ((long) toppings.size() + (long) condiments.size() > 1) {
            int lastComma = toppingsAndCondiments.lastIndexOf(", ");
            String replacementString = toppings.size() + condiments.size() == 2 ? " AND " : ", AND ";
            toppingsAndCondiments.replace(lastComma, lastComma + 2, replacementString);
        }
        return toppingsAndCondiments;
    }

    private StringBuilder buildBasicSandwichDescription() {
        StringBuilder result = new StringBuilder();
        long protienCount = proteins.size();

        if (protienCount == 0L) {
            result.append("VEGGIE");
        } else if (protienCount == 1L) {
            result.append("SINGLE ").append(proteins.get(0).toString().toUpperCase(Locale.ROOT));
        } else if (protienCount == 2L) {
            result.append("DOUBLE ").append(proteins.get(0).toString().toUpperCase(Locale.ROOT));
        } else if (protienCount == 3L) {
            result.append("TRIPLE ").append(proteins.get(0).toString().toUpperCase(Locale.ROOT));
        } else {
            result.append("BIG ").append(protienCount).append(" ").append(proteins.get(0).toString().toUpperCase(Locale.ROOT));
        }

        switch (this.wrapping) {
            case bun:
                result.append(" ON ").append(this.wrapping.toString().toUpperCase(Locale.ROOT));
                break;
        }

        return result;
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
