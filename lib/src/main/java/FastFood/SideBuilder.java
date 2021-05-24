package FastFood;

import java.util.ArrayList;
import java.util.List;

public class SideBuilder {
    String name;
    SideOrder type;
    ItemSize size;
    List<Condiment> condiments;
    Float price;

    public SideBuilder(){
        type = SideOrder.none;
        size = ItemSize.none;
        price = null;
        condiments = new ArrayList<>();
    }
    public SideBuilder of(SideOrder sideOrder){
        type = sideOrder;
        return this;
    }

    public SideBuilder size(ItemSize size){
        this.size = size;
        return this;
    }

    public SideBuilder withCondiment(Condiment condiment){
        condiments.add(condiment);
        return this;
    }

    public SideBuilder atPrice(Float price){
        this.price = price;
        return this;
    }

    public Side build(){
        validateSide();
        // getDefaultPrice();

        return new Side(type, size, condiments, price);
    }

    private void getDefaultPrice() {
        switch(size){
            case small:
                price = 1.00f;
                break;
            case medium:
                price = 1.50f;
                break;
            case large:
                price = 1.75f;
                break;
            case extra_large:
                price = 2.00f;
                break;
            default:
                throw new IllegalArgumentException("No size specified for pricing");
        }
    }

    private void validateSide() {
        if(type == SideOrder.none){
            throw new IllegalArgumentException("No side order type specified");
        }

        if(size == ItemSize.none)
            size = ItemSize.medium;
    }
}
