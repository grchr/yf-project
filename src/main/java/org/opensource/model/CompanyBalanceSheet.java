package org.opensource.model;

public class CompanyBalanceSheet extends AbstractCompanyInformation {
  private String totalAssets;
  private String totalLiabilitiesNetMinorityInterest;
  private String totalEquityGrossMinorityInterest;
  private String totalCapitalization;
  private String commonStockEquity;
  private String netTangibleAssets;
  private String workingCapital;
  private String investedCapital;
  private String tangibleBookValue;
  private String totalDebt;
  private String netDebt;
  private String sharesIssued;
  private String ordinarySharesNumber;

  private CompanyBalanceSheet(Builder builder) {
    super(builder); // Calling the parent class constructor
    this.totalAssets = builder.totalAssets;
    this.totalLiabilitiesNetMinorityInterest = builder.totalLiabilitiesNetMinorityInterest;
    this.totalEquityGrossMinorityInterest = builder.totalEquityGrossMinorityInterest;
    this.totalCapitalization = builder.totalCapitalization;
    this.commonStockEquity = builder.commonStockEquity;
    this.netTangibleAssets = builder.netTangibleAssets;
    this.workingCapital = builder.workingCapital;
    this.investedCapital = builder.investedCapital;
    this.tangibleBookValue = builder.tangibleBookValue;
    this.totalDebt = builder.totalDebt;
    this.netDebt = builder.netDebt;
    this.sharesIssued = builder.sharesIssued;
    this.ordinarySharesNumber = builder.ordinarySharesNumber;
  }

  public String getTotalAssets() {
    return totalAssets;
  }

  public String getTotalLiabilitiesNetMinorityInterest() {
    return totalLiabilitiesNetMinorityInterest;
  }

  public String getTotalEquityGrossMinorityInterest() {
    return totalEquityGrossMinorityInterest;
  }

  public String getTotalCapitalization() {
    return totalCapitalization;
  }

  public String getCommonStockEquity() {
    return commonStockEquity;
  }

  public String getNetTangibleAssets() {
    return netTangibleAssets;
  }

  public String getWorkingCapital() {
    return workingCapital;
  }

  public String getInvestedCapital() {
    return investedCapital;
  }

  public String getTangibleBookValue() {
    return tangibleBookValue;
  }

  public String getTotalDebt() {
    return totalDebt;
  }

  public String getNetDebt() {
    return netDebt;
  }

  public String getSharesIssued() {
    return sharesIssued;
  }

  public String getOrdinarySharesNumber() {
    return ordinarySharesNumber;
  }

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private String totalAssets = DEFAULT;
    private String totalLiabilitiesNetMinorityInterest = DEFAULT;
    private String totalEquityGrossMinorityInterest = DEFAULT;
    private String totalCapitalization = DEFAULT;
    private String commonStockEquity = DEFAULT;
    private String netTangibleAssets = DEFAULT;
    private String workingCapital = DEFAULT;
    private String investedCapital = DEFAULT;
    private String tangibleBookValue = DEFAULT;
    private String totalDebt = DEFAULT;
    private String netDebt = DEFAULT;
    private String sharesIssued = DEFAULT;
    private String ordinarySharesNumber = DEFAULT;

    public Builder withTotalAssets(String totalAssets) {
      this.totalAssets = totalAssets;
      return this;
    }

    public Builder withTotalLiabilitiesNetMinorityInterest(String totalLiabilitiesNetMinorityInterest) {
      this.totalLiabilitiesNetMinorityInterest = totalLiabilitiesNetMinorityInterest;
      return this;
    }

    public Builder withTotalEquityGrossMinorityInterest(String totalEquityGrossMinorityInterest) {
      this.totalEquityGrossMinorityInterest = totalEquityGrossMinorityInterest;
      return this;
    }

    public Builder withTotalCapitalization(String totalCapitalization) {
      this.totalCapitalization = totalCapitalization;
      return this;
    }

    public Builder withCommonStockEquity(String commonStockEquity) {
      this.commonStockEquity = commonStockEquity;
      return this;
    }

    public Builder withNetTangibleAssets(String netTangibleAssets) {
      this.netTangibleAssets = netTangibleAssets;
      return this;
    }

    public Builder withWorkingCapital(String workingCapital) {
      this.workingCapital = workingCapital;
      return this;
    }

    public Builder withInvestedCapital(String investedCapital) {
      this.investedCapital = investedCapital;
      return this;
    }

    public Builder withTangibleBookValue(String tangibleBookValue) {
      this.tangibleBookValue = tangibleBookValue;
      return this;
    }

    public Builder withTotalDebt(String totalDebt) {
      this.totalDebt = totalDebt;
      return this;
    }

    public Builder withNetDebt(String netDebt) {
      this.netDebt = netDebt;
      return this;
    }

    public Builder withSharesIssued(String sharesIssued) {
      this.sharesIssued = sharesIssued;
      return this;
    }

    public Builder withOrdinarySharesNumber(String ordinarySharesNumber) {
      this.ordinarySharesNumber = ordinarySharesNumber;
      return this;
    }

    @Override
    public CompanyBalanceSheet build() {
      return new CompanyBalanceSheet(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
