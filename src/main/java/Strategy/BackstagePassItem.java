package Strategy;

public class BackstagePassItem extends Item {
    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {

        if (quality < 50) {
            quality = quality + 1;

            if (sellIn < 11) {
                updateIfLessThanFifty();
            }

            if (sellIn < 6) {
                updateIfLessThanFifty();
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = quality - quality;
        }
    }
}
