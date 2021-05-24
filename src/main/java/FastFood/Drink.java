package FastFood;

import javax.naming.SizeLimitExceededException;
import java.util.Locale;

class Drink implements Item {
    DrinkType type;
    ItemSize size;
    DrinkModification modification;
    Float price;

    Drink(DrinkType type, ItemSize size, DrinkModification mod, Float price) {
        this.type = type;
        this.size = size;
        this.modification = mod;
        this.price = price;
    }

    Drink(Drink in){
        this.type = in.type;
        this.size = in.size;
        this.modification = in.modification;
        this.price = in.price;
    }
    @Override
    public String getName() {
        return type.toString().toUpperCase(Locale.ROOT);
    }

    @Override
    public Float getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String drinkDescription = "\n" + getSizeDescription();
                drinkDescription+= " ";
                drinkDescription+= getName();
                drinkDescription+= getOptionalModificationDescription();
                drinkDescription+= (price == null ? "" : ":\t" + price.toString());
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
