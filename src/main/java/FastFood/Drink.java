package FastFood;

import java.util.Locale;

class Drink implements Item {
    DrinkType type;
    ItemSize size;
    DrinkModification modification;
    Float price;
    String name;

    Drink(DrinkType type, ItemSize size, DrinkModification mod, Float price) {
        this.type = type;
        this.size = size;
        this.modification = mod;
        this.price = price;
    }

    Drink(DrinkType type, ItemSize size, DrinkModification mod, Float price, String name) {
        this.type = type;
        this.size = size;
        this.modification = mod;
        this.price = price;
        this.name = name;
    }
    Drink(Drink in) {
        this.type = in.type;
        this.size = in.size;
        this.modification = in.modification;
        this.price = in.price;
        this.name = in.name;
    }

    public DrinkType getType() {
        return type;
    }

    public ItemSize getSize() {
        return size;
    }

    public DrinkModification getModification() {
        return modification;
    }

    @Override
    public String getName() {
        String drinkName = name == null ?
                type.toString().toUpperCase(Locale.ROOT) :
                this.name;
        return drinkName.replace('_',' ');
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String drinkDescription = getSizeDescription();
        drinkDescription += " ";
        drinkDescription += getName();
        drinkDescription += getOptionalModificationDescription();
        drinkDescription += (price == null ? "" : ":\t" + price);
        return drinkDescription.length() > 0 ? drinkDescription : "";

    }

    String getOptionalModificationDescription() {
        return this.modification == DrinkModification.none ?
                "" : " W/" + this.modification
                .toString()
                .toUpperCase(Locale.ROOT)
                .replace('_', ' ');
    }

    private String getSizeDescription() {

        return size.toString().toUpperCase(Locale.ROOT);
    }
}
