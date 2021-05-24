package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MealTests {
    @Test
    public void emptyMealReturnsNoItems() {
        Meal meal = new MealBuilder().build();

        assertEquals("CUSTOM MEAL\n", meal.getName());
    }

    @Test
    public void defaultSingleBurgerMealReturnsOneOfEachMediumSizedItems() {
        Meal meal = new MealBuilder()
                .withSandwich(new SandwichBuilder()
                        .withName("SINGLE BURGER")
                        .withWrapping(SandwichWrapping.bun)
                        .withProtien(Protein.beef)
                        .build())
                .withDrink(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .withSide(new SideBuilder()
                        .of(SideOrder.french_fries)
                        .build())
                .atPrice(5.00f)
                .withName("Single Burger meal")
                .build();

        assertEquals("Single Burger meal\nSINGLE BURGER\n\tBEEF ON BUN\nMEDIUM FRENCH FRIES\nMEDIUM COKE W/ICE\n5.0", meal.toString());
    }

    @Test
    public void defaultMealWtihSmallSizeReturnsAllSmallItems() {

    }

    @Test
    public void defaultMealWithMediumSizeReturnsAllMediumItems() {

    }

    @Test
    public void defaultMealWithLargeSizeReturnsAllLargeItems() {

    }

    @Test
    public void defaultMealWithExLargeSizeReturnsAllExLargeItems() {

    }

    @Test
    public void customOrderMealReturnsItemsOrderedAtIndividualPricing() {

    }

    @Test
    public void defaultMealCanBeCustomizedOnIndividualItems() {

    }

    @Test
    public void defaultMealCanHaveExtraItemsAddedToIt() {

    }

}
