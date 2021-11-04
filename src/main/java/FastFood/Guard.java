package FastFood;

public class Guard {
    public static void againstInvalidSize(ItemSize size) {
        if( size == null)
            throw new IllegalArgumentException("Size cannot be null");
        if( size == ItemSize.none)
            throw new IllegalArgumentException("Size must be specified");
    }

    public static void againstInvalidDrinkType(DrinkType drinkType){
        if( drinkType == DrinkType.none)
            throw new IllegalArgumentException("Missing DrinkType");
        if( drinkType == null){
            throw new IllegalArgumentException("DrinkType cannot be null");
        }
    }
}
