package FastFood;

public class DrinkBuilder {
    String name;
    DrinkType type;
    ItemSize size;
    DrinkModification modification;

    Float price;

    public DrinkBuilder(){
        modification = DrinkModification.ice;
        size = ItemSize.medium;
        this.price = null;
    }

    public DrinkBuilder of(DrinkType type){
        this.type = type;
        return this;
    }
    public DrinkBuilder size(ItemSize size){
        this.size = size;
        return this;
    }
    public DrinkBuilder withModification(DrinkModification modification){
        this.modification = modification;
        return this;
    }

    public DrinkBuilder atPrice(Float price){
        this.price = price;
        return this;
    }

    public Drink build(){
        validateDrink();
        //setDefaultPrice();

        return new Drink(this.type, this.size, this.modification, this.price);
    }

    private void validateDrink() {
//        if(name == null)
//            throw new IllegalArgumentException("Name of drink not specified");
//
//        if( size == ItemSize.none){
//            throw new IllegalArgumentException("No drink size specified");
//        }
//
//        if(type == DrinkType.none){
//            throw new IllegalArgumentException("No drink type specified")
//        }

    }

}
