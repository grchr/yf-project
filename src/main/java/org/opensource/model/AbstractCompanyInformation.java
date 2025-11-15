package org.opensource.model;

public abstract class AbstractCompanyInformation {

  protected String companyName;
  protected String companyTicker;
  protected double currentPrice;
  protected String currency;

  protected AbstractCompanyInformation(Builder<?> builder) {
    this.companyName = builder.companyName;
    this.companyTicker = builder.companyTicker;
    this.currentPrice = builder.currentPrice;
    this.currency = builder.currency;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getCompanyTicker() {
    return companyTicker;
  }

  public double getCurrentPrice() {
    return currentPrice;
  }

  public String getCurrency() {
    return currency;
  }

  public abstract static class Builder<T extends Builder<T>> {

    protected static final String DEFAULT = "--";

    protected static double DEFAULT_DOUBLE = Double.NaN;
    private String companyName = DEFAULT;
    private String companyTicker = DEFAULT;
    private double currentPrice = DEFAULT_DOUBLE;

    private String currency = DEFAULT;

    public T withCompanyName(String companyName) {
      this.companyName = companyName;
      return self();
    }

    public T withCompanyTicker(String companyTicker) {
      this.companyTicker = companyTicker;
      return self();
    }

    public T withCurrentPrice(double currentPrice) {
      this.currentPrice = currentPrice;
      return self();
    }

    public T withCurrency(String currency) {
      this.currency = currency;
      return self();
    }

    protected abstract T self();

    public abstract AbstractCompanyInformation build();
  }
}
