package Strategy;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {

        if (quality < 50) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            {
                updateIfLessThanFifty();
            }
        }
    }
}