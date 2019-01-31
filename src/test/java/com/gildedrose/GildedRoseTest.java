package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void update_quality() {
    final int sellIn = 0;
    final int quality = 0;
    final String name = "foo";

    final String itemString = doUpdateQuality(sellIn, quality, name);

    Approvals.verify(itemString);
  }

  private String doUpdateQuality(final int sellIn, final int quality, final String name) {
    Item[] items = new Item[]{ new Item(name, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    return app.items[0].toString();
  }

}
