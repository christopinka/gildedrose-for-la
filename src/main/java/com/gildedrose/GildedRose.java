package com.gildedrose;

class GildedRose {
    final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityAndSellIn() {
        for (Item item : items) {
            if (item.name.equals(ItemName.HAND.getValue()))
                continue;

            item.quality = updateQuality(item);

            item.sellIn = updateSellIn(item);

            item.quality = updateQualitySellInTerminated(item);
        }

    }

    private static int updateQualitySellInTerminated(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals(ItemName.CONCERT.getValue())) {
                return 0;
            }
            if (item.quality > 0
                && item.name.equals(ItemName.MAGIC.getValue())) {
                return item.quality - 2;
            }
            if (item.quality > 0
                && !item.name.equals(ItemName.BRIE.getValue())) {
                return item.quality - 1;
            }
            if (item.name.equals(ItemName.BRIE.getValue()) && item.quality < 50) {
                return item.quality + 1;
            }
        }
        return item.quality;
    }

    private static int updateQuality(Item item) {
        if ((item.name.equals(ItemName.BRIE.getValue()) || item.name.equals(ItemName.CONCERT.getValue())) && item.quality >= 50) {
            return item.quality;
        }
        if (item.name.equals(ItemName.BRIE.getValue())) {
            return item.quality + 1;
        }
        if (item.name.equals(ItemName.CONCERT.getValue()) && item.sellIn >= 11) {
            return item.quality + 1;
        }

        if (item.name.equals(ItemName.CONCERT.getValue()) && item.sellIn >= 6) {
            return Math.min(50, item.quality + 2);
        }
        if (item.name.equals(ItemName.CONCERT.getValue())) {
            return Math.min(50, item.quality + 3);
        }

        if(item.quality > 1 && item.name.equals(ItemName.MAGIC.getValue())){
            return item.quality - 2;
        }

        if (item.quality > 0) {
            return item.quality - 1;
        }

        return item.quality;
    }

    private static int updateSellIn(Item item) {

        return item.sellIn - 1;

    }
}
