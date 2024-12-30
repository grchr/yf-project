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

public abstract class AbstractWebDataService<T extends Enum<T>> {

  protected static String DEFAULT = "--";
  protected static final String TITLES_SELECTOR = "div[class^=column sticky], div[class^=column]";

  protected final BlockingQueue<HtmlUnitDriver> driverPool = new LinkedBlockingQueue<>(10);

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
    for (int i = 0; i < 10; i++) {
      driverPool.add(new HtmlUnitDriver());
    }
  }

  protected HtmlUnitDriver acquireDriver() throws InterruptedException {
    return driverPool.take(); // Blocks if no driver is available
  }

  protected void releaseDriver(HtmlUnitDriver driver) {
    driverPool.offer(driver); // Return driver to pool
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
