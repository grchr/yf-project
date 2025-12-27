package org.opensource.model.web;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooSessionException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YahooSessionTest {

  @Test
  void YahooSessionTest() throws YahooSessionException {
    YahooSession session = YahooSessionFactory.getYahooSession();
    assertTrue(StringUtils.isNotEmpty(session.crumb()));
  }
}
