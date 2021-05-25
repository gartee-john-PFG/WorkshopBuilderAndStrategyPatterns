package Strategy;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    List<Item> items = new ArrayList<>();

    public GildedRose(Item[] items) {

        for (Item item : items)
            switch (item.name) {
                case Item.AGED_BRIE:
                    this.items.add(new AgedBrieItem(item.name, item.sellIn, item.quality));
                    break;
                case Item.BACKSTAGE_PASS:
                    this.items.add(new BackstagePassItem(item.name, item.sellIn, item.quality));
                case Item.SULFURAS:
                    this.items.add(new SulfurasItem(item.name, item.sellIn, item.quality));
                    break;
                default:
                   this.items.add( new Item(item.name, item.sellIn, item.quality));
            }
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateItem();
        }
    }
}
