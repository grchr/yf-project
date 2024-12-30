package org.opensource.model;

public abstract class AbstractCompanyInformation {

  protected String companyName;
  protected String companyTicker;
  protected double currentPrice;

  protected AbstractCompanyInformation(Builder<?> builder) {
    this.companyName = builder.companyName;
    this.companyTicker = builder.companyTicker;
    this.currentPrice = builder.currentPrice;
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

  public abstract static class Builder<T extends Builder<T>> {

    protected static final String DEFAULT = "--";

    protected static double DEFAULT_DOUBLE = Double.NaN;
    private String companyName = DEFAULT;
    private String companyTicker = DEFAULT;
    private double currentPrice = DEFAULT_DOUBLE;

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

    protected abstract T self();

    public abstract AbstractCompanyInformation build();
  }
}
