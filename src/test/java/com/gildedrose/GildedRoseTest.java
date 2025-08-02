package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDegradeQualityByFourWhenMagicAndSellInEqualZero(){
        Item[] items = new Item[]{new Item(ItemName.MAGIC.getValue(), 0, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(38, app.items[0].quality);

    }
    @Test
    void shouldDegradeQualityByTwoWhenMagicAndSellInLEqualOne(){
        Item[] items = new Item[]{new Item(ItemName.MAGIC.getValue(), 1, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(40, app.items[0].quality);

    }

  @Test
    void shouldDegradeQualityByTwoWhenMagicAndSellInGreaterThanOne(){
        Item[] items = new Item[]{new Item(ItemName.MAGIC.getValue(), 42, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(40, app.items[0].quality);

    }

  @Test
    void shouldDegradeQualityByFourWhenMagicAndSellInLessThanZero(){
        Item[] items = new Item[]{new Item(ItemName.MAGIC.getValue(), -1, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(38, app.items[0].quality);

    }

    @Test
    void shouldDegradeQualityByTwoWhenNotBrieOrMagicAndSellInEqualZero(){
        Item[] items = new Item[]{new Item(ItemName.STOCK.getValue(), 0, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(40, app.items[0].quality);

    }
   @Test
    void shouldDegradeQualityByTwoWhenNotBrieOrMagicAndSellInLessThanZero(){
        Item[] items = new Item[]{new Item(ItemName.STOCK.getValue(), -1, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(40, app.items[0].quality);

    }

 @Test
    void shouldDegradeQualityByOneWhenNotBrieOrMagicAndSellInGreaterThanZero(){
        Item[] items = new Item[]{new Item(ItemName.STOCK.getValue(), 42, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(41, app.items[0].quality);

    }
@Test
    void shouldDegradeQualityByOneWhenNotBrieOrMagicAndSellInEqualOne(){
        Item[] items = new Item[]{new Item(ItemName.STOCK.getValue(), 1, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertEquals(41, app.items[0].quality);

    }




}
