package FastFood;

import java.util.HashMap;
import java.util.Map;

public class DefaultMenu {
    private static Map<MenuItem, Item> currentMenu = new HashMap<MenuItem, Item>() {
        {
            put(MenuItem.single_burger_meal,
                    new MealBuilder()
                            .withSandwich(new SandwichBuilder()
                                    .withWrapping(SandwichWrapping.bun)
                                    .withProtien(Protein.beef)
                                    .withCondiment(Condiment.catsup)
                                    .withCondiment(Condiment.mustard)
                                    .withTopping(Topping.pickles)
                                    .withTopping(Topping.onion)
                                    .atPrice(null)
                                    .build()
                            )
                            .withSide(new SideBuilder()
                                    .of(SideOrder.french_fries)
                                    .size(ItemSize.medium)
                                    .withCondiment(Condiment.salt)
                                    .withCondiment(Condiment.pepper)
                                    .withCondiment(Condiment.catsup)
                                    .atPrice(null)
                                    .build()
                            )
                            .withDrink(new DrinkBuilder()
                                    .of(DrinkType.coke)
                                    .size(ItemSize.medium)
                                    .atPrice(null)
                                    .build()
                            )
                            .atPrice(5.00f)
                            .build());
            put(MenuItem.double_burger_meal,
                    new MealBuilder()
                            .withSandwich(new SandwichBuilder()
                                    .withWrapping(SandwichWrapping.bun)
                                    .withProtien(Protein.beef)
                                    .withProtien(Protein.beef)
                                    .withCondiment(Condiment.catsup)
                                    .withCondiment(Condiment.mustard)
                                    .withTopping(Topping.pickles)
                                    .withTopping(Topping.onion)
                                    .atPrice(null)
                                    .build()
                            )
                            .withSide(new SideBuilder()
                                    .of(SideOrder.french_fries)
                                    .size(ItemSize.medium)
                                    .withCondiment(Condiment.salt)
                                    .withCondiment(Condiment.pepper)
                                    .withCondiment(Condiment.catsup)
                                    .atPrice(null)
                                    .build()
                            )
                            .withDrink(new DrinkBuilder()
                                    .of(DrinkType.coke)
                                    .size(ItemSize.medium)
                                    .atPrice(null)
                                    .build())
                            .atPrice(5.00f)
                            .build());
            put(MenuItem.triple_burger_meal,
                    new MealBuilder()
                            .withSandwich(new SandwichBuilder()
                                    .withWrapping(SandwichWrapping.bun)
                                    .withProtien(Protein.beef)
                                    .withProtien(Protein.beef)
                                    .withProtien(Protein.beef)
                                    .withCondiment(Condiment.catsup)
                                    .withCondiment(Condiment.mustard)
                                    .withTopping(Topping.pickles)
                                    .withTopping(Topping.onion)
                                    .build()
                            )
                            .withSide(new SideBuilder()
                                    .of(SideOrder.french_fries)
                                    .size(ItemSize.medium)
                                    .withCondiment(Condiment.salt)
                                    .withCondiment(Condiment.pepper)
                                    .withCondiment(Condiment.catsup)
                                    .atPrice(null)
                                    .build()
                            )
                            .withDrink(new DrinkBuilder()
                                    .of(DrinkType.coke)
                                    .size(ItemSize.medium)
                                    .atPrice(null)
                                    .build()
                            )
                            .atPrice(5.00f)
                            .build());
        }
    };

    public static Map<MenuItem, Item> getMenu() {
        return currentMenu;
    }
}
