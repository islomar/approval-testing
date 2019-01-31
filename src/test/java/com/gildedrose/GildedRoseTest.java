package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void update_quality() throws Exception {
    final String name = "foo";
    final int sellIn = 0;
    final int quality = 0;

    CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
        new String[]{ name },
        new Integer[]{ sellIn },
        new Integer[]{ quality }
    );
  }

  private String doUpdateQuality(final String name, final int sellIn, final int quality) {
    Item[] items = new Item[]{ new Item(name, sellIn, quality) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    return app.items[0].toString();
  }

}
