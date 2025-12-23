package org.opensource.model.response.charts;

import java.math.BigDecimal;

public class Dividends{

  private long date;
  private BigDecimal amount;

  public long getDate() {
    return date;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Dividends{" +
            "date=" + date +
            ", amount=" + amount +
            '}';
  }
}