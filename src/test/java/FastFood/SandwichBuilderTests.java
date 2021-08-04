package FastFood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SandwichBuilderTests {
    @Test
    public void customSandwichReturnsFullDescription(){
        Sandwich sandwich = new SandwichBuilder()
                .withProtien(Protein.beef)
                .withWrapping(SandwichWrapping.bun)
                .withTopping(Topping.lettuce)
                .withCondiment(Condiment.mustard)
                .withCondiment(Condiment.catsup)
                .atPrice(2.50f)
                .build();

        assertEquals("SINGLE BEEF ON BUN WITH LETTUCE, MUSTARD, AND CATSUP\n\t2.5", sandwich.toString() );
    }
}
