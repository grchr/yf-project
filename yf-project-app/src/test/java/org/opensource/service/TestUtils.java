package org.opensource.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestUtils {

  public static String getRandomStockToTest() {
    List<String> stockSymbols = Arrays.asList("AAPL", "ADBE", "TSLA", "MSFT", "NVDA", "AME", "C", "IBM");

    // Generate a random index based on the size of the list
    Random random = new Random();
    int randomIndex = random.nextInt(stockSymbols.size());
    // Return the stock symbol at the random index
    return stockSymbols.get(randomIndex);
  }
}
