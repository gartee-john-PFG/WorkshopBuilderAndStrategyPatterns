package FastFood;

import java.util.HashMap;
import java.util.Map;

public class DefaultMenu {
    private static Map<MenuItem, Item> currentMenu;
    private static DefaultMenu single_instance = null;

    private static Map<MenuItem, Item> buildDefaultMenu() {
        return new HashMap<MenuItem, Item>() {
            {
                put(MenuItem.small_drink,
                        new DrinkBuilder()
                                .of(DrinkType.coke)
                                .size(ItemSize.small)
                                .withModification(DrinkModification.ice)
                                .atPrice(1.00f)
                                .build()
                );
                put(MenuItem.medium_drink,
                        new DrinkBuilder()
                                .of(DrinkType.coke)
                                .size(ItemSize.medium)
                                .withModification(DrinkModification.ice)
                                .atPrice(1.25f)
                                .build()
                );
                put(MenuItem.large_drink,
                        new DrinkBuilder()
                                .of(DrinkType.coke)
                                .size(ItemSize.large)
                                .withModification(DrinkModification.ice)
                                .atPrice(1.50f)
                                .build()
                );
                put(MenuItem.extra_large_drink,
                        new DrinkBuilder()
                                .of(DrinkType.coke)
                                .size(ItemSize.extra_large)
                                .withModification(DrinkModification.ice)
                                .atPrice(1.75f)
                                .build()
                );
                put(MenuItem.small_side, new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.small)
                        .withCondiment(Condiment.salt)
                        .atPrice(1.00f)
                        .build()
                );
                put(MenuItem.medium_side, new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.medium)
                        .withCondiment(Condiment.salt)
                        .atPrice(1.25f)
                        .build()
                );
                put(MenuItem.large_side, new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.large)
                        .withCondiment(Condiment.salt)
                        .atPrice(1.75f)
                        .build()
                );
                put(MenuItem.extra_large_side, new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.extra_large)
                        .withCondiment(Condiment.salt)
                        .atPrice(2.00f)
                        .build()
                );
                put(MenuItem.single_sandwich, new SandwichBuilder()
                        .withProtien(Protein.beef)
                        .withWrapping(SandwichWrapping.bun)
                        .withCondiment(Condiment.catsup)
                        .withCondiment(Condiment.mustard)
                        .atPrice(2.00f)
                        .build()
                );
                put(MenuItem.double_sandwich, new SandwichBuilder()
                        .withProtien(Protein.beef)
                        .withProtien(Protein.beef)
                        .withWrapping(SandwichWrapping.bun)
                        .withCondiment(Condiment.catsup)
                        .withCondiment(Condiment.mustard)
                        .atPrice(3.00f)
                        .build()
                );
                put(MenuItem.triple_sandwich, new SandwichBuilder()
                        .withProtien(Protein.beef)
                        .withProtien(Protein.beef)
                        .withProtien(Protein.beef)
                        .withWrapping(SandwichWrapping.bun)
                        .withCondiment(Condiment.catsup)
                        .withCondiment(Condiment.mustard)
                        .atPrice(4.00f)
                        .build()
                );
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
                                .withName("SINGLE WONDERFUL MEAL")
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
                                .withName("DOUBLE WONDERFUL MEAL")
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
                                .withName("TRIPLE WONDERFUL MEAL")
                                .atPrice(5.00f)
                                .build());
            }
        };
    }

    public static Map<MenuItem, Item> getMenu() {
        if(currentMenu == null)
            currentMenu = buildDefaultMenu();

        return currentMenu;
    }
}
