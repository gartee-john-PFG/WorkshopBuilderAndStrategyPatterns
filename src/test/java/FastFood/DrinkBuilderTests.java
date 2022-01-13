package FastFood;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DrinkBuilderTests {
    @Test
    public void aDefaultCoke_ReturnsDrinkMediumCokeWithIce() {
        Drink coke = new DrinkBuilder()
                .atPrice(1.5f)
                .of(DrinkType.coke)
                .build();


        assertEquals("MEDIUM COKE W/ICE:\t1.5", coke.toString());
    }

    @Test
    public void notSpecifyingDrinkTypeReturnsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Drink drink = new DrinkBuilder()
                    .build();
        });
    }

    @Test
    public void specifyingNullDrinkTypeReturnsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Drink drink = new DrinkBuilder()
                    .of(null)
                    .build();
        });
    }

    @Test
    public void specifyingNullDrinkSizeReturnsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Drink drink = new DrinkBuilder()
                    .of(DrinkType.coke)
                    .size(null)
                    .build();
        });
    }

    @Test
    public void specifyingNullDrinModificationSetsNone(){
        Drink coke = new DrinkBuilder()
                .atPrice(1.5f)
                .of(DrinkType.coke)
                .withModification(null)
                .build();


        assertEquals(coke.modification, DrinkModification.none);
    }

    @Test
    public void missingDrinkSizeReturnsException(){
        assertThrows(IllegalArgumentException.class, () -> {
            Drink drink = new DrinkBuilder()
                    .of(DrinkType.coke)
                    .size(ItemSize.none)
                    .build();
        });
    }

    @Test
    public void aLargeCokeWithNoIce_ReturnsProperDescription(){
        Drink coke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.large)
                .withModification(DrinkModification.no_ice)
                .atPrice(2.0f)
                .build();

        assertEquals("LARGE COKE W/NO ICE:\t2.0", coke.toString());
    }

    @Test
    public void aDrinkHasTheCorrectPriceForSpecifiedSize(){
        Drink smCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.small)
                .atPrice(1.0f)
                .withName("Small Coke")
                .build();
        Drink medCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .atPrice(1.5f)
                .withName("Medium Coke")
                .size(ItemSize.medium)
                .build();
        Drink lgCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.large)
                .atPrice(2.0f)
                .withName("Large Coke")
                .build();
        Drink exLgCoke = new DrinkBuilder()
                .atPrice(2.5f)
                .of(DrinkType.coke)
                .size(ItemSize.extra_large)
                .withName("Extra-large Coke")
                .build();

        assertEquals(1.00f, smCoke.getPrice());
        assertEquals("Small Coke", smCoke.getName());
        assertEquals(1.50f, medCoke.getPrice());
        assertEquals("Medium Coke", medCoke.getName());
        assertEquals(2.00f, lgCoke.getPrice());
        assertEquals("Large Coke", lgCoke.getName());
        assertEquals(2.50f, exLgCoke.getPrice());
        assertEquals("Extra-large Coke", exLgCoke.getName());
    }

    @Test
    void orderingADrinkFromTheMenuReturnsCorrectDescriptionAndPrice(){
        Drink drink = new DrinkBuilder()
        .fromMenuItem(MenuItem.large_drink)
        .build();

        assertEquals("LARGE COKE W/ICE:\t1.5", drink.toString());
    }

    @Test
    void orderingMountainDewFromTheMenuReturnsCorrectDescription(){
        Drink drink = new DrinkBuilder()
                .fromMenuItem(MenuItem.medium_drink)
                .of(DrinkType.mountain_dew)
                .build();

        assertEquals("MEDIUM MOUNTAIN DEW W/ICE:\t1.25", drink.toString());
    }

    @Test
    public void orderingItemNotOnMenuThrowsInvalidArgumentException(){
        Map<MenuItem, Item> customMenu = new HashMap<>(){
            {
                put(MenuItem.large_drink, new DrinkBuilder()
                        .of(DrinkType.coffee)
                        .size(ItemSize.large)
                        .atPrice(1F)
                        .withModification(DrinkModification.none)
                        .build()
                );
            }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            Drink drink = new DrinkBuilder()
                    .fromMenu(customMenu)
                    .fromMenuItem(MenuItem.small_drink)
                    .build();
        });
    }

    @Test
    public void orderFromCustomMenuReturnsCorrectDescription(){
        Map<MenuItem, Item> customMenu = new HashMap<>(){
            {
                put(MenuItem.large_drink, new DrinkBuilder()
                .of(DrinkType.coffee)
                        .size(ItemSize.large)
                        .atPrice(1F)
                        .withModification(DrinkModification.none)
                        .build()
                );
            }
        };

        Drink drink = new DrinkBuilder()
                .fromMenu(customMenu)
                .fromMenuItem(MenuItem.large_drink)
                .build();

        assertEquals("LARGE COFFEE:\t1.0", drink.toString());
    }

    @Test
    public void drinkOrderFromAMenuCanBeCustomized(){
        Map<MenuItem, Item> customMenu = new HashMap<>(){
            {
                put(MenuItem.large_drink, new DrinkBuilder()
                        .of(DrinkType.coffee)
                        .size(ItemSize.large)
                        .atPrice(1F)
                        .withModification(DrinkModification.none)
                        .build()
                );
            }
        };
        Drink drink = new DrinkBuilder()
                .fromMenu(customMenu)
                .fromMenuItem(MenuItem.large_drink)
                .build();
        assertEquals(DrinkModification.none, drink.getModification());

        Drink customizedDrink = drink.changeModification(DrinkModification.ice);

        assertEquals(DrinkModification.ice, customizedDrink.getModification());
    }

    @Test
    public void buildAnExtraLargeMountainDewWithExtraIceThatCostsOneDollarTwentyFiveCents(){
        //  add drink builder implementation and remove comments from the asserts, below

        //        assertEquals(DrinkType.mountain_dew, drink.getType());
        //        assertEquals(ItemSize.extra_large, drink.getSize());
        //        assertEquals(DrinkModification.extra_ice, drink.getModification());
        //        assertEquals(1.25f, drink.getPrice());
    }

    @Test
    public void buildMediumCokeWithIceWithCustomSippyCover(){
        //  Create a new type called DrinkCover with the options of:
        //  none
        //  standard
        //  sippy_cover
        //
        //  Add the ability to include the new cover in the DrinkBuilder and support it in the Drink class
        //
        //  construct the drink described in the test name, above
        //
        //  create the assertions required to validate your feature
        //
        //  questions:
        //      does this impact orders?  meals?
        //      if so, how?

    }
}
