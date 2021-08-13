package Strategy;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    List<Item> items = new ArrayList<>();

    public GildedRose(Item[] items) {

        for (Item item : items)
            this.items.add(ItemFactory.createItem(item));
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateItem();
        }
    }
}
