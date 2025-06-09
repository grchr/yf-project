package org.opensource.service;

import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.model.AbstractCompanyInformation;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractWebDataService<T extends Enum<T>> {

  protected static String DEFAULT = "--";
  protected static final String TITLES_SELECTOR = "div[class^=column sticky], div[class^=column]";

  private int minPoolSize = 10;
  private int maxPoolSize = 50;
  private AtomicInteger currentDriverCount = new AtomicInteger(0);
  private final BlockingQueue<HtmlUnitDriver> driverPool = new LinkedBlockingQueue<>();

  protected final ExecutorService executor =  new ThreadPoolExecutor(10, 50,
      60L, TimeUnit.SECONDS,
      new SynchronousQueue<>());

  public void shutdown() {
    // Shutdown the executor service
    executor.shutdown();
    driverPool.clear();
  }

  protected AbstractWebDataService() {
    // Initialize pool with pre-created drivers
    for (int i = 0; i < minPoolSize; i++) {
      driverPool.add(new HtmlUnitDriver());
    }
  }

  protected HtmlUnitDriver acquireDriver() throws InterruptedException {
    HtmlUnitDriver driver = driverPool.poll();
    if (driver != null) return driver;

    // Try to create a new driver if under max
    if (currentDriverCount.get() < maxPoolSize) {
      currentDriverCount.incrementAndGet();
      return new HtmlUnitDriver();
    }

    // Otherwise wait until one is available, blocks if none is available
    return driverPool.take();
  }

  protected void releaseDriver(HtmlUnitDriver driver) {
    int currentCount = currentDriverCount.get();

    // If we're over min size, discard the driver and cleanup
    if (currentCount > minPoolSize) {
      currentDriverCount.decrementAndGet();
      driver.quit();
    } else {
      // Return to pool
      driverPool.offer(driver);
    }
  }

  protected abstract AbstractCompanyInformation.Builder populateBuilderWithMainInfo(Elements dataElements);

  protected abstract EnumMap<T, String> fillMap(Elements dataElements, int valueOffset);

  protected String getTitleValue(Map<T, String> map, T title) {
    if (map.containsKey(title)) {
      return map.get(title);
    }
    return DEFAULT;
  }
}
