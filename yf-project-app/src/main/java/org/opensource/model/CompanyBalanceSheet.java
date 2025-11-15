package org.opensource.model;

import java.util.Objects;

public class CompanyBalanceSheet extends AbstractCompanyInformation {
  private double totalAssets;
  private double totalLiabilitiesNetMinorityInterest;
  private double totalEquityGrossMinorityInterest;
  private double totalCapitalization;
  private double commonStockEquity;
  private double netTangibleAssets;
  private double workingCapital;
  private double investedCapital;
  private double tangibleBookValue;
  private double totalDebt;
  private double netDebt;
  private double sharesIssued;
  private double ordinarySharesNumber;

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

  public double getTotalAssets() {
    return totalAssets;
  }

  public double getTotalLiabilitiesNetMinorityInterest() {
    return totalLiabilitiesNetMinorityInterest;
  }

  public double getTotalEquityGrossMinorityInterest() {
    return totalEquityGrossMinorityInterest;
  }

  public double getTotalCapitalization() {
    return totalCapitalization;
  }

  public double getCommonStockEquity() {
    return commonStockEquity;
  }

  public double getNetTangibleAssets() {
    return netTangibleAssets;
  }

  public double getWorkingCapital() {
    return workingCapital;
  }

  public double getInvestedCapital() {
    return investedCapital;
  }

  public double getTangibleBookValue() {
    return tangibleBookValue;
  }

  public double getTotalDebt() {
    return totalDebt;
  }

  public double getNetDebt() {
    return netDebt;
  }

  public double getSharesIssued() {
    return sharesIssued;
  }

  public double getOrdinarySharesNumber() {
    return ordinarySharesNumber;
  }

  @Override
  public String toString() {
    return "CompanyBalanceSheet{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", totalAssets=" + totalAssets +
            ", totalLiabilitiesNetMinorityInterest=" + totalLiabilitiesNetMinorityInterest +
            ", totalEquityGrossMinorityInterest=" + totalEquityGrossMinorityInterest +
            ", totalCapitalization=" + totalCapitalization +
            ", commonStockEquity=" + commonStockEquity +
            ", netTangibleAssets=" + netTangibleAssets +
            ", workingCapital=" + workingCapital +
            ", investedCapital=" + investedCapital +
            ", tangibleBookValue=" + tangibleBookValue +
            ", totalDebt=" + totalDebt +
            ", netDebt=" + netDebt +
            ", sharesIssued=" + sharesIssued +
            ", ordinarySharesNumber=" + ordinarySharesNumber +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyBalanceSheet that)) return false;
    return Double.compare(that.totalAssets, totalAssets) == 0 &&
            Double.compare(that.totalLiabilitiesNetMinorityInterest, totalLiabilitiesNetMinorityInterest) == 0 &&
            Double.compare(that.totalEquityGrossMinorityInterest, totalEquityGrossMinorityInterest) == 0 &&
            Double.compare(that.totalCapitalization, totalCapitalization) == 0 &&
            Double.compare(that.commonStockEquity, commonStockEquity) == 0 &&
            Double.compare(that.netTangibleAssets, netTangibleAssets) == 0 &&
            Double.compare(that.workingCapital, workingCapital) == 0 &&
            Double.compare(that.investedCapital, investedCapital) == 0 &&
            Double.compare(that.tangibleBookValue, tangibleBookValue) == 0 &&
            Double.compare(that.totalDebt, totalDebt) == 0 &&
            Double.compare(that.netDebt, netDebt) == 0 &&
            Double.compare(that.sharesIssued, sharesIssued) == 0 &&
            Double.compare(that.ordinarySharesNumber, ordinarySharesNumber) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalAssets, totalLiabilitiesNetMinorityInterest, totalEquityGrossMinorityInterest,
            totalCapitalization, commonStockEquity, netTangibleAssets, workingCapital, investedCapital,
            tangibleBookValue, totalDebt, netDebt, sharesIssued, ordinarySharesNumber);
  }

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private double totalAssets = DEFAULT_DOUBLE;
    private double totalLiabilitiesNetMinorityInterest = DEFAULT_DOUBLE;
    private double totalEquityGrossMinorityInterest = DEFAULT_DOUBLE;
    private double totalCapitalization = DEFAULT_DOUBLE;
    private double commonStockEquity = DEFAULT_DOUBLE;
    private double netTangibleAssets = DEFAULT_DOUBLE;
    private double workingCapital = DEFAULT_DOUBLE;
    private double investedCapital = DEFAULT_DOUBLE;
    private double tangibleBookValue = DEFAULT_DOUBLE;
    private double totalDebt = DEFAULT_DOUBLE;
    private double netDebt = DEFAULT_DOUBLE;
    private double sharesIssued = DEFAULT_DOUBLE;
    private double ordinarySharesNumber = DEFAULT_DOUBLE;

    public Builder withTotalAssets(double totalAssets) {
      this.totalAssets = totalAssets;
      return this;
    }

    public Builder withTotalLiabilitiesNetMinorityInterest(double totalLiabilitiesNetMinorityInterest) {
      this.totalLiabilitiesNetMinorityInterest = totalLiabilitiesNetMinorityInterest;
      return this;
    }

    public Builder withTotalEquityGrossMinorityInterest(double totalEquityGrossMinorityInterest) {
      this.totalEquityGrossMinorityInterest = totalEquityGrossMinorityInterest;
      return this;
    }

    public Builder withTotalCapitalization(double totalCapitalization) {
      this.totalCapitalization = totalCapitalization;
      return this;
    }

    public Builder withCommonStockEquity(double commonStockEquity) {
      this.commonStockEquity = commonStockEquity;
      return this;
    }

    public Builder withNetTangibleAssets(double netTangibleAssets) {
      this.netTangibleAssets = netTangibleAssets;
      return this;
    }

    public Builder withWorkingCapital(double workingCapital) {
      this.workingCapital = workingCapital;
      return this;
    }

    public Builder withInvestedCapital(double investedCapital) {
      this.investedCapital = investedCapital;
      return this;
    }

    public Builder withTangibleBookValue(double tangibleBookValue) {
      this.tangibleBookValue = tangibleBookValue;
      return this;
    }

    public Builder withTotalDebt(double totalDebt) {
      this.totalDebt = totalDebt;
      return this;
    }

    public Builder withNetDebt(double netDebt) {
      this.netDebt = netDebt;
      return this;
    }

    public Builder withSharesIssued(double sharesIssued) {
      this.sharesIssued = sharesIssued;
      return this;
    }

    public Builder withOrdinarySharesNumber(double ordinarySharesNumber) {
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
