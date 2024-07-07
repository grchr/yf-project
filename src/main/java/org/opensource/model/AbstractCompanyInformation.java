package org.opensource.model;

public abstract class AbstractCompanyInformation {

  private String companyName;
  private String companyTicker;
  private String currentPrice;

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

  public String getCurrentPrice() {
    return currentPrice;
  }

  public abstract static class Builder<T extends Builder<T>> {

    protected static final String DEFAULT = "--";
    private String companyName = DEFAULT;
    private String companyTicker = DEFAULT;
    private String currentPrice = DEFAULT;

    public T withCompanyName(String companyName) {
      this.companyName = companyName;
      return self();
    }

    public T withCompanyTicker(String companyTicker) {
      this.companyTicker = companyTicker;
      return self();
    }

    public T withCurrentPrice(String currentPrice) {
      this.currentPrice = currentPrice;
      return self();
    }

    protected abstract T self();

    public abstract AbstractCompanyInformation build();
  }
}
