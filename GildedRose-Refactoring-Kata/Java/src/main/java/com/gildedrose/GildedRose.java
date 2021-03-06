package com.gildedrose;

class GildedRose {
  Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  void updateQuality() {

    for (int i = 0; i < items.length; i++) {
      Item item = this.items[i];

      switch (item.name) {
        case "Sulfuras, Hand of Ragnaros":
          items[i].quality = 80;
          break;

        case "Aged Brie": {
          if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 0) {
              item.quality++;
            }
          }
          item.sellIn--;
          break;
        }

        case "Backstage passes to a TAFKAL80ETC concert": {
          if (item.quality < 50) {
            if (item.sellIn > 10) {
              item.quality++;
            } else if (item.sellIn <= 10 && item.sellIn > 5) {
              item.quality += 2;
            } else if (item.sellIn <= 5 && item.sellIn >= 0) {
              item.quality += 3;
            }
          }
          item.sellIn--;
          if (item.sellIn < 0) {
            item.quality = 0;
          }
          break;
        }

        case "Conjured Mana Cake": {
          item.sellIn--;
          if (item.quality > 0) {
            item.quality -= 2;
            if (item.sellIn < 0 && item.quality > 0) {
              item.quality -= 2;
            }
          }

          if (item.quality < 0) {
            item.quality = 0;
          }
          break;
        }

        default: {
          item.sellIn--;
          if (item.quality > 0) {
            item.quality--;
            if (item.sellIn < 0 && item.quality > 0) {
              item.quality--;
            }
          }
        }
      }
    }
  }
}
