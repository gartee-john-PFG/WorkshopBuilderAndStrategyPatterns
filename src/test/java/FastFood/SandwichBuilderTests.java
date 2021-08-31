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
    @Test
    public void doubleeBurgerCanBeOrderedFromTheMenu(){
        Sandwich sandwich = new SandwichBuilder()
                .fromMenuItem(MenuItem.double_sandwich)
                .build();

        assertEquals("DOUBLE BEEF ON BUN WITH CATSUP AND MUSTARD\n\t3.0", sandwich.toString());
    }
    @Test
    public void tripleBugerWithToppingsCanBeOrderedFromTheMenu(){
        Sandwich sandwich = new SandwichBuilder()
                .fromMenuItem(MenuItem.triple_sandwich)
                .withTopping(Topping.pickles)
                .build();

        assertEquals("TRIPLE BEEF ON BUN WITH PICKLES, CATSUP, AND MUSTARD\n\t4.0", sandwich.toString());
    }
}
