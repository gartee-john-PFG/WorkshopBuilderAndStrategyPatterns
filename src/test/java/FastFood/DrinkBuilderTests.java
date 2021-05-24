package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrinkBuilderTests {
    @Test
    public void aDefaultCoke_ReturnsDrinkMediumCokeWithIce() {
        Drink coke = new DrinkBuilder()
                .atPrice(1.5f)
                .of(DrinkType.coke)
                .build();


        assertEquals("\nMEDIUM COKE W/ICE:\t1.5", coke.toString());
    }

    @Test
    public void aLargeCokeWithNoIce_ReturnsProperDescription(){
        Drink coke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.large)
                .withModification(DrinkModification.no_ice)
                .atPrice(2.0f)
                .build();

        assertEquals("\nLARGE COKE W/NO ICE:\t2.0", coke.toString());
    }

    @Test
    public void aDrinkHasTheCorrectPriceForSpecifiedSize(){
        Drink smCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.small)
                .atPrice(1.0f)
                .build();
        Drink medCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .atPrice(1.5f)
                .size(ItemSize.medium)
                .build();
        Drink lgCoke = new DrinkBuilder()
                .of(DrinkType.coke)
                .size(ItemSize.large)
                .atPrice(2.0f)
                .build();
        Drink exLgCoke = new DrinkBuilder()
                .atPrice(2.5f)
                .of(DrinkType.coke)
                .size(ItemSize.extra_large)
                .build();

        assertEquals(1.00f, smCoke.getPrice());
        assertEquals(1.50f, medCoke.getPrice());
        assertEquals(2.00f, lgCoke.getPrice());
        assertEquals(2.50f, exLgCoke.getPrice());
    }
}
