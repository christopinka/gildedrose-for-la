package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class ApprovalsTest {

    @Test
    public void shouldTestAllCombinations() {


        Integer[] qualityValues = {0, 2, 49, 52};
        Integer[] sellInValues = {-1, 0, 11, 5, 6};
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
            new String[]{
                ItemName.STOCK.getValue(),
                ItemName.BRIE.getValue(),
                ItemName.CONCERT.getValue(),
                ItemName.HAND.getValue(),
                ItemName.MAGIC.getValue()},
            sellInValues,
            qualityValues
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        return ItemPrinter(items[0]);
    }

    private static String ItemPrinter(Item item) {
        return "name: " + ItemName.getNameByValue(item.name)
            + " | sell in: " + item.sellIn
            + " | quality: " + item.quality;
    }

}
