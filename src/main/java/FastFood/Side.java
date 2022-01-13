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
        this.condiments.addAll(condiments);
    }

    Side(Side in) {
        this.type = in.type;
        this.size = in.size;
        this.price = in.price;

        this.condiments = new ArrayList<>();
        this.condiments.addAll(in.condiments);

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
        return getSizeDescription()
                + " "
                + type.toString().replace('_', ' ').toUpperCase(Locale.ROOT)
                + getCondimentsDescription()
                + (this.price == null ? "" : ":\t" + getPrice());
    }

    private String getCondimentsDescription() {
        StringBuilder result = new StringBuilder();

        if (condiments.size() > 0)
            result.append(" WITH ");

        for (Condiment condiment : condiments) {
            result
                    .append(condiment
                            .toString()
                            .toUpperCase(Locale.ROOT)
                            .replace('_', ' '))
                    .append(", ");

        }

        if (condiments.size() > 0) {
            removeTrailingCommaAndSpace(result);
            int commaSpacePosition = result.lastIndexOf(", ");
            if(commaSpacePosition >= 0)
                result.replace(commaSpacePosition, commaSpacePosition + ", ".length(), ", AND ");
        }

        if(condiments.size() == 2){
            int start = result.indexOf(", AND");
            result.replace(start, start + ", AND".length(), " AND");
        }

        return result.toString();
    }

    private StringBuilder removeTrailingCommaAndSpace(StringBuilder result) {
        int lastCommaSpacePosition = result.lastIndexOf(", ");
        return result.replace(lastCommaSpacePosition, lastCommaSpacePosition + ", ".length(), "");
    }

    private String getSizeDescription() {

        return size.toString().toUpperCase(Locale.ROOT).replace("_", " ");
    }

    public Object getSize() {
        return this.size;
    }
}
