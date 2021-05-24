package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTests {

    @Test public void OrderingJustACokeReturnsProperDescription(){
        Order order = new OrderBuilder()
                .withItem(new DrinkBuilder()
                        .of(DrinkType.coke)
                        .atPrice(1.00f)
                        .build())
                .build();

        assertEquals("Customer:\nMEDIUM COKE W/ICE:\t1.0\n1.0", order.toString());
    }

    @Test public void OrderingTwoCokesReturnsProperDescription(){
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

        assertEquals("Customer:\nMEDIUM COKE W/ICE:\t1.5\nMEDIUM COKE W/ICE:\t1.5\n3.0", order.toString());
    }

    @Test public void OrderingCokeWithCustomerNameReturnsProperDescription(){
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

        assertEquals("Joe Blow:\nMEDIUM COKE W/ICE:\t1.0\nMEDIUM COKE W/ICE:\t1.0\n2.0", order.toString());
    }

    @Test public void OrderingCokeAndSmFryReturnsProperDescription(){
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

        assertEquals("Joe Blow:\nMEDIUM COKE W/ICE:\t1.0\nSMALL FRENCH FRIES:\t1.0\n2.0", order.toString());
    }
}
