package com.gildedrose;

public enum ItemName {
    STOCK("Stock"),
    BRIE("Aged Brie"),
    CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    HAND("Sulfuras, Hand of Ragnaros"),
    MAGIC("Conjured");

    private final String value;

    ItemName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getNameByValue(String value) {
        for (ItemName itemName : ItemName.values()) {
            if (itemName.getValue().equals(value)) {
                return itemName.name();
            }
        }
        return null;
    }
}
