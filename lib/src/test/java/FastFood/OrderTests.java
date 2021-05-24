package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTests {

    @Test public void OrderingJustACokeReturnsProperDescription(){
        Order order = new OrderBuilder()
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .build();

        assertEquals("Customer:\tMEDIUM COKE W/ICE:\t1.5\n", order.toString());
    }

    @Test public void OrderingTwoCokesReturnsProperDescription(){
        Order order = new OrderBuilder()
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .build();

        assertEquals("Customer:\tMEDIUM COKE W/ICE:\t1.5\n\tMEDIUM COKE W/ICE:\t1.5\n", order.toString());
    }

    @Test public void OrderingCokeWithCustomerNameReturnsProperDescription(){
        Order order = new OrderBuilder()
                .forCustomer("Joe Blow")
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .build();

        assertEquals("Joe Blow:\tMEDIUM COKE W/ICE:\t1.5\n\tMEDIUM COKE W/ICE:\t1.5\n", order.toString());
    }

    @Test public void OrderingCokeAndSmFryReturnsProperDescription(){
        Order order = new OrderBuilder()
                .forCustomer("Joe Blow")
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .build())
                .withItem(new SideBuilder()
                        .of(SideOrder.french_fries)
                        .size(ItemSize.small)
                        .build())
                .build();

        assertEquals("Joe Blow:\tMEDIUM COKE W/ICE:\t1.5\n\tSMALL FRENCH FRIES:\t1.0\n", order.toString());
    }
}
