package Strategy;

public class ItemFactory {
    public static Item createItem(Item item){
        switch (item.name) {
            case Item.AGED_BRIE:
                return new AgedBrieItem(item.name, item.sellIn, item.quality);
            case Item.BACKSTAGE_PASS:
                return new BackstagePassItem(item.name, item.sellIn, item.quality);
            case Item.SULFURAS:
                return new SulfurasItem(item.name, item.sellIn, item.quality);
            default:
                return new Item(item.name, item.sellIn, item.quality);
        }
    }
}
