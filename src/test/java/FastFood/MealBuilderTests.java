package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealBuilderTests {
    @Test
    public void emptyMealReturnsNoItems() {
        Meal meal = new MealBuilder().build();

        assertEquals("CUSTOM MEAL", meal.getName());
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
                .withName("Single Burger Meal")
                .build();

        assertEquals("Single Burger Meal\n\tSINGLE BURGER\n\tSINGLE BEEF ON BUN\n\tMEDIUM FRENCH FRIES\n\tMEDIUM COKE W/ICE\n\t5.0", meal.toString());
    }

    @Test
    public void defaultMealWithSmallSizeReturnsAllSmallItems() {

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
        //  how would we customize the toppings on an existing sandwich from the menu?
    }

    @Test
    public void defaultMealCanHaveExtraItemsAddedToIt() {
        // Create an order with an extra item added to the meal
    }
}
