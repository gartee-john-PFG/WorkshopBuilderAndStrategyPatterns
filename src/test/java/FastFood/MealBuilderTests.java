package FastFood;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealBuilderTests {
    @Test
    public void emptyMealReturnsNoItems() {
        Meal meal = new MealBuilder().build();

        assertEquals("CUSTOM MEAL", meal.getName());
    }

    @Test
    public void defaultSingleBurgerMenuItemReturnsOneOfEachMediumSizedItems() {
        Meal meal = new MealBuilder()
                .fromMenuItem(MenuItem.single_burger_meal)
                .build();

        assertEachItemInMealIsSingleOrMedium(meal);
    }

    private void assertEachItemInMealIsSingleOrMedium(Meal meal) {
        assertEquals(1, meal.getSandwiches().size());
        assertEquals(1, meal.getDrinks().size());
        assertEquals(1, meal.getSides().size());
        assertEquals(ItemSize.medium, meal.getDrinks().get(0).getSize());
        assertEquals(ItemSize.medium, meal.getSides().get(0).getSize());
        assertEquals(1, meal.getSandwiches().get(0).proteins.size());
    }

    @Test
    void tripleBurgerMealFromMenuReturnsCorrectDescriptionAndPrice(){
        Meal meal = new MealBuilder()
                .fromMenuItem(MenuItem.triple_burger_meal)
                .build();

        assertEquals("TRIPLE WONDERFUL MEAL\n\tTRIPLE BEEF ON BUN WITH PICKLES, ONION, CATSUP, AND MUSTARD\n\tMEDIUM FRENCH FRIES WITH SALT, PEPPER, AND CATSUP\n\tMEDIUM COKE W/ICE\n\t5.0", meal.toString());
    }

    @Test
    public void defaultMenuMealCanBeCustomizedOnIndividualItems() {
        //  how would we customize the toppings on an existing sandwich from the menu?
        Meal meal = new MealBuilder()
                .fromMenuItem(MenuItem.triple_burger_meal)
                .build();

        Sandwich sandwich = meal.getSandwiches().get(0);
        List<Condiment> condiments = sandwich.condiments;
        condiments.add(Condiment.mayo);
        meal.updateSandwich(sandwich, 0);

        assertArrayEquals(condiments.toArray(), meal.getSandwiches().get(0).condiments.toArray());
    }

    @Test
    public void defaultMenuMealWithSmallSizeReturnsAllSmallItems() {

    }

    @Test
    public void defaultMenuMealWithMediumSizeReturnsAllMediumItems() {

    }

    @Test
    public void defaultMenuMealWithLargeSizeReturnsAllLargeItems() {

    }

    @Test
    public void defaultMenuMealWithExLargeSizeReturnsAllExLargeItems() {

    }

    @Test
    public void customOrderMealReturnsItemsOrderedAtIndividualPricing() {

    }

    @Test
    public void defaultMealCanHaveExtraItemsAddedToIt() {
        // Create an order with an extra item added to the meal
    }
}
