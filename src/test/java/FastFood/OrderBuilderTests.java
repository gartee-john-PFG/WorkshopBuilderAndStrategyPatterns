package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderBuilderTests {

    @Test
    public void OrderingJustACokeReturnsProperDescription() {
        Order order = new OrderBuilder()
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.00f)
                        .build())
                .build();

        assertEquals("Customer:\n\tMEDIUM COKE W/ICE:\t1.0\n1.0", order.toString());
    }

    @Test
    public void OrderingTwoCokesReturnsProperDescription() {
        Order order = new OrderBuilder()
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.5f)
                        .build())
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.5f)
                        .build())
                .build();

        assertEquals("Customer:\n\tMEDIUM COKE W/ICE:\t1.5\n\tMEDIUM COKE W/ICE:\t1.5\n3.0", order.toString());
    }

    @Test
    public void orderingCokeWithCustomerNameReturnsProperDescription() {
        Order order = new OrderBuilder()
                .forCustomer("Joe Blow")
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.00f)
                        .build())
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.0f)
                        .build())
                .build();

        assertEquals("Joe Blow:\n\tMEDIUM COKE W/ICE:\t1.0\n\tMEDIUM COKE W/ICE:\t1.0\n2.0", order.toString());
    }

    @Test
    public void OrderingCokeAndSmFryReturnsProperDescription() {
        Order order = new OrderBuilder()
                .forCustomer("Joe Blow")
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.00f)
                        .build())
                .withItem(new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.small)
                        .atPrice(1.00f)
                        .build())
                .build();

        assertEquals("Joe Blow:\n\tMEDIUM COKE W/ICE:\t1.0\n\tSMALL FRENCH FRIES:\t1.0\n2.0", order.toString());
    }

    @Test
    void orderSingleBurgerMealReturnsCorrectItems() {
        Order order = new OrderBuilder()
                .withItem(new MealBuilder()
                        .fromMenuItem(MenuItem.single_burger_meal)
                        .build())
                .forCustomer("Joseph Blowhard")
                .build();

        assertEquals("Joseph Blowhard", order.getName());
        assertEquals("SINGLE WONDERFUL MEAL", order.getOrderText());
        assertEquals("Joseph Blowhard:\n\tSINGLE WONDERFUL MEAL\n\tSINGLE BEEF ON BUN WITH PICKLES, ONION, CATSUP, AND MUSTARD\n\tMEDIUM FRENCH FRIES\n\tMEDIUM COKE W/ICE\n\t5.0\n5.0", order.toString());
    }
}
