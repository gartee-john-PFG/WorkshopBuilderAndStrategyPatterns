package FastFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Side implements Item {
    SideOrder type;
    ItemSize size;
    Float price;
    List<Condiment> condiments;

    Side(SideOrder type, ItemSize size, List<Condiment> condiments, Float price) {
        this.type = type;
        this.size = size;
        this.price = price;
        this.condiments = new ArrayList<>();

        for (Condiment condiment : condiments) {
            this.condiments.add(condiment);
        }
    }

    Side(Side in) {
        this.type = in.type;
        this.size = in.size;
        this.price = in.price;

        this.condiments = new ArrayList<>();

        for(Condiment condiment: in.condiments)
            this.condiments.add(condiment);

    }


    @Override
    public String getName() {
        return this.type.toString().toUpperCase(Locale.ROOT);
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n" + getSizeDescription()
                + " "
                + type.toString().replace('_',' ').toUpperCase(Locale.ROOT)
                + (this.price == null ? "" : ":\t" + getPrice());
    }

    private String getSizeDescription() {
        return size.toString().toUpperCase(Locale.ROOT);
    }
}
