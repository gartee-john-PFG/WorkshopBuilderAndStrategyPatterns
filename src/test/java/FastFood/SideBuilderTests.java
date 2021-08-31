package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SideBuilderTests {
    @Test
    void sideOrderReturnsCorrectSizeAndDescription(){
        Side side = new SideBuilder()
                .of(SideOrder.onion_rings)
                .size(ItemSize.extra_large)
                .withCondiment(Condiment.salt)
                .withCondiment(Condiment.thousand_island)
                .atPrice(2.00f)
                .build();

        assertEquals("EXTRA LARGE ONION RINGS WITH SALT AND THOUSAND ISLAND:\t2.0", side.toString());
    }

    @Test
    void sideOrderFromMenuReturnsCorrectDescriptionAndPrice(){
        Side side = new SideBuilder()
                .fromMenuItem(MenuItem.large_side)
                .of(SideOrder.onion_rings)
                .build();

        assertEquals("LARGE ONION RINGS WITH SALT:\t1.75", side.toString());
    }
}
