package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void update_quality() {
    Item[] items = new Item[]{ new Item("foo", 0, 0) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    Approvals.verify(app.items[0].toString());
  }

}
