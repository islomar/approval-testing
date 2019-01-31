package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void update_quality() throws Exception {

    CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
        new String[]{ "foo",
                      "Aged Brie",
                      "Backstage passes to a TAFKAL80ETC concert",
                      "Sulfuras, Hand of Ragnaros" },
        new Integer[]{ 0, 11 },
        new Integer[]{ 0, 1, 49, 50 }
    );
  }

  private String doUpdateQuality(final String name, final int sellIn, final int quality) {
    Item[] items = new Item[]{ new Item(name, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    return app.items[0].toString();
  }

}
