package FastFood;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder {
    private  SandwichWrapping wrapping;
    private List<Protein> proteins;
    private List<Condiment> condiments;
    private List<Topping> toppings;
    private Float price;
    private String name;

    SandwichBuilder() {
        proteins = new ArrayList<>();
        condiments = new ArrayList<>();
        toppings = new ArrayList<>();
        name = "";

    }

    public SandwichBuilder withWrapping(SandwichWrapping wrapping) {
        this.wrapping = wrapping;
        return this;
    }

    public SandwichBuilder withProtien(Protein protein) {
        this.proteins.add(protein);
        return this;
    }

    public SandwichBuilder withCondiment(Condiment condiment) {
        this.condiments.add(condiment);
        return this;
    }

    public SandwichBuilder withTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }

    public SandwichBuilder atPrice(Float price){
        this.price = price;
        return this;
    }

    public SandwichBuilder withName(String name){
        this.name = name;
        return this;
    }

    public Sandwich build() {
        return new Sandwich(this.wrapping, this.proteins, this.toppings, this.condiments, this.price, this.name);
    }
}
