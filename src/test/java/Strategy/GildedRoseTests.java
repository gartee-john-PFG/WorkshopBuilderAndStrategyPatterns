package Strategy;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

//  exercise:  Strategy Workshop: add Conjured items per the README.MD description found with the source
//  exercise:  Factory Workshop:  add factory method for implementing the Conjured items per the README.MD

public class GildedRoseTests {
    @Test
    void approveGildedRose() {
        String[] names = {"foo", Item.AGED_BRIE, Item.BACKSTAGE_PASS, Item.SULFURAS};
        Integer[] sellins = { -1, 0, 1, 5, 6, 10, 11, 12, 6, 2 };
        Integer[] qualities = { 0, 1, 48, 49, 50 };
        CombinationApprovals.verifyAllCombinations(
                this::runGildedRose,
                names,
                sellins,
                qualities);
    }

    private Item runGildedRose(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose.items.get(0);
    }
}
