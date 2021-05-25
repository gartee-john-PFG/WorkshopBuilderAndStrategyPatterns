package Strategy;

public class Item {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", quality=" + quality + ", sellIn=" + sellIn + "]";
    }

    void updateIfLessThanFifty() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    void updateItem() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality > 0) {
                    quality = quality - 1;
            }
        }
    }
}
