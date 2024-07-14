package org.opensource.model;

import java.util.Objects;

public class CompanyKeyStatistics extends AbstractCompanyInformation {
  private String marketCap;
  private String enterpriseValue;
  private String revenue;
  private String netIncomeAviToCommon;
  private String totalDebt;

  private double trailingPE;
  private double forwardPE;
  private double pegRatio;
  private double ratioPS;
  private double ratioPB;
  private double evToRevenue;
  private double evToEBITDA;
  private double profitMarginPercentage;
  private double operatingMarginPercentage;
  private double returnOnAssetsPercentage;
  private double returnOnEquityPercentage;
  private double revenuePerShare;
  private double quarterlyRevenueGrowthPercentage;
  private double grossProfit;
  private String EBITDA;
  private double dilutedEPS;
  private double quartEarningsGrowthPercentage;
  private double totalCash;
  private double totalCashPerShare;
  private double totalDebtToEquityPercentage;

  private CompanyTradingInformation tradingInformation;

  private CompanyKeyStatistics(Builder builder) {
    super(builder); // Call to the parent builder
    this.marketCap = builder.marketCap;
    this.enterpriseValue = builder.enterpriseValue;
    this.revenue = builder.revenue;
    this.netIncomeAviToCommon = builder.netIncomeAviToCommon;
    this.totalDebt = builder.totalDebt;
    this.EBITDA = builder.EBITDA;

    this.trailingPE = builder.trailingPE;
    this.forwardPE = builder.forwardPE;
    this.pegRatio = builder.pegRatio;
    this.ratioPS = builder.ratioPS;
    this.ratioPB = builder.ratioPB;
    this.evToRevenue = builder.evToRevenue;
    this.evToEBITDA = builder.evToEBITDA;
    this.profitMarginPercentage = builder.profitMarginPercentage;
    this.operatingMarginPercentage = builder.operatingMarginPercentage;
    this.returnOnAssetsPercentage = builder.returnOnAssetsPercentage;
    this.returnOnEquityPercentage = builder.returnOnEquityPercentage;
    this.revenuePerShare = builder.revenuePerShare;
    this.quarterlyRevenueGrowthPercentage = builder.quarterlyRevenueGrowthPercentage;
    this.grossProfit = builder.grossProfit;
    this.dilutedEPS = builder.dilutedEPS;
    this.quartEarningsGrowthPercentage = builder.quartEarningsGrowthPercentage;
    this.totalCash = builder.totalCash;
    this.totalCashPerShare = builder.totalCashPerShare;
    this.totalDebtToEquityPercentage = builder.totalDebtToEquityPercentage;
    this.tradingInformation = builder.tradingInformation;
  }

  public String getMarketCap() {
    return marketCap;
  }

  public String getEnterpriseValue() {
    return enterpriseValue;
  }

  public double getTrailingPE() {
    return trailingPE;
  }

  public double getForwardPE() {
    return forwardPE;
  }

  public double getPegRatio() {
    return pegRatio;
  }

  public double getRatioPS() {
    return ratioPS;
  }

  public double getRatioPB() {
    return ratioPB;
  }

  public double getEvToRevenue() {
    return evToRevenue;
  }

  public double getEvToEBITDA() {
    return evToEBITDA;
  }

  public double getProfitMarginPercentage() {
    return profitMarginPercentage;
  }

  public double getOperatingMarginPercentage() {
    return operatingMarginPercentage;
  }

  public double getReturnOnAssetsPercentage() {
    return returnOnAssetsPercentage;
  }

  public double getReturnOnEquityPercentage() {
    return returnOnEquityPercentage;
  }

  public String getRevenue() {
    return revenue;
  }

  public double getRevenuePerShare() {
    return revenuePerShare;
  }

  public double getQuarterlyRevenueGrowthPercentage() {
    return quarterlyRevenueGrowthPercentage;
  }

  public double getGrossProfit() {
    return grossProfit;
  }

  public String getEBITDA() {
    return EBITDA;
  }

  public String getNetIncomeAviToCommon() {
    return netIncomeAviToCommon;
  }

  public double getDilutedEPS() {
    return dilutedEPS;
  }

  public double getQuartEarningsGrowthPercentage() {
    return quartEarningsGrowthPercentage;
  }

  public double getTotalCash() {
    return totalCash;
  }

  public double getTotalCashPerShare() {
    return totalCashPerShare;
  }

  public String getTotalDebt() {
    return totalDebt;
  }

  public double getTotalDebtToEquityPercentage() {
    return totalDebtToEquityPercentage;
  }

  public CompanyTradingInformation getTradingInformation() {
    return tradingInformation;
  }

  @Override
  public String toString() {
    return "CompanyKeyStatistics{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", marketCap='" + marketCap + '\'' +
            ", enterpriseValue='" + enterpriseValue + '\'' +
            ", trailingPE=" + trailingPE +
            ", forwardPE=" + forwardPE +
            ", pegRatio=" + pegRatio +
            ", ratioPS=" + ratioPS +
            ", ratioPB=" + ratioPB +
            ", evToRevenue=" + evToRevenue +
            ", evToEBITDA=" + evToEBITDA +
            ", profitMargin=" + profitMarginPercentage +
            ", operatingMarginPercentage=" + operatingMarginPercentage +
            ", returnOnAssetsPercentage=" + returnOnAssetsPercentage +
            ", returnOnEquityPercentage=" + returnOnEquityPercentage +
            ", revenue='" + revenue + '\'' +
            ", revenuePerShare=" + revenuePerShare +
            ", quarterlyRevenueGrowthPercentage=" + quarterlyRevenueGrowthPercentage +
            ", grossProfit=" + grossProfit +
            ", EBITDA=" + EBITDA +
            ", netIncomeAviToCommon='" + netIncomeAviToCommon + '\'' +
            ", dilutedEPS=" + dilutedEPS +
            ", quartEarningsGrowthPercentage=" + quartEarningsGrowthPercentage +
            ", totalCash=" + totalCash +
            ", totalCashPerShare=" + totalCashPerShare +
            ", totalDebt='" + totalDebt + '\'' +
            ", totalDebtToEquityPercentage=" + totalDebtToEquityPercentage +
            ", tradingInformation=" + tradingInformation +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyKeyStatistics that)) return false;
    return Double.compare(that.trailingPE, trailingPE) == 0 &&
            Double.compare(that.forwardPE, forwardPE) == 0 &&
            Double.compare(that.pegRatio, pegRatio) == 0 &&
            Double.compare(that.ratioPS, ratioPS) == 0 &&
            Double.compare(that.ratioPB, ratioPB) == 0 &&
            Double.compare(that.evToRevenue, evToRevenue) == 0 &&
            Double.compare(that.evToEBITDA, evToEBITDA) == 0 &&
            Double.compare(that.profitMarginPercentage, profitMarginPercentage) == 0 &&
            Double.compare(that.operatingMarginPercentage, operatingMarginPercentage) == 0 &&
            Double.compare(that.returnOnAssetsPercentage, returnOnAssetsPercentage) == 0 &&
            Double.compare(that.returnOnEquityPercentage, returnOnEquityPercentage) == 0 &&
            Double.compare(that.revenuePerShare, revenuePerShare) == 0 &&
            Double.compare(that.quarterlyRevenueGrowthPercentage, quarterlyRevenueGrowthPercentage) == 0 &&
            Double.compare(that.grossProfit, grossProfit) == 0 &&
            Objects.equals(that.EBITDA, EBITDA) &&
            Double.compare(that.dilutedEPS, dilutedEPS) == 0 &&
            Double.compare(that.quartEarningsGrowthPercentage, quartEarningsGrowthPercentage) == 0 &&
            Double.compare(that.totalCash, totalCash) == 0 &&
            Double.compare(that.totalCashPerShare, totalCashPerShare) == 0 &&
            Double.compare(that.totalDebtToEquityPercentage, totalDebtToEquityPercentage) == 0 &&
            Objects.equals(marketCap, that.marketCap) &&
            Objects.equals(enterpriseValue, that.enterpriseValue) &&
            Objects.equals(revenue, that.revenue) &&
            Objects.equals(netIncomeAviToCommon, that.netIncomeAviToCommon) &&
            Objects.equals(totalDebt, that.totalDebt) &&
            Objects.equals(tradingInformation, that.tradingInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(marketCap, enterpriseValue, revenue, netIncomeAviToCommon, totalDebt,
            trailingPE, forwardPE, pegRatio, ratioPS, ratioPB, evToRevenue, evToEBITDA, profitMarginPercentage,
            operatingMarginPercentage, returnOnAssetsPercentage, returnOnEquityPercentage, revenuePerShare,
            quarterlyRevenueGrowthPercentage, grossProfit, EBITDA, dilutedEPS, quartEarningsGrowthPercentage,
            totalCash, totalCashPerShare, totalDebtToEquityPercentage, tradingInformation);
  }

  public static class Builder extends AbstractCompanyInformation.Builder<CompanyKeyStatistics.Builder> {
    private String marketCap = DEFAULT;
    private String enterpriseValue = DEFAULT;
    private String revenue = DEFAULT;
    private String netIncomeAviToCommon = DEFAULT;
    private String totalDebt = DEFAULT;

    private double trailingPE = DEFAULT_DOUBLE;
    private double forwardPE = DEFAULT_DOUBLE;
    private double pegRatio = DEFAULT_DOUBLE;
    private double ratioPS = DEFAULT_DOUBLE;
    private double ratioPB = DEFAULT_DOUBLE;
    private double evToRevenue = DEFAULT_DOUBLE;
    private double evToEBITDA = DEFAULT_DOUBLE;
    private double profitMarginPercentage = DEFAULT_DOUBLE;
    private double operatingMarginPercentage = DEFAULT_DOUBLE;
    private double returnOnAssetsPercentage = DEFAULT_DOUBLE;
    private double returnOnEquityPercentage = DEFAULT_DOUBLE;
    private double revenuePerShare = DEFAULT_DOUBLE;
    private double quarterlyRevenueGrowthPercentage = DEFAULT_DOUBLE;
    private double grossProfit = DEFAULT_DOUBLE;
    private String EBITDA = DEFAULT;
    private double dilutedEPS = DEFAULT_DOUBLE;
    private double quartEarningsGrowthPercentage = DEFAULT_DOUBLE;
    private double totalCash = DEFAULT_DOUBLE;
    private double totalCashPerShare = DEFAULT_DOUBLE;
    private double totalDebtToEquityPercentage = DEFAULT_DOUBLE;
    private CompanyTradingInformation tradingInformation = new CompanyTradingInformation.Builder().build();

    public Builder withMarketCap(String marketCap) {
      this.marketCap = marketCap;
      return this;
    }

    public Builder withEnterpriseValue(String enterpriseValue) {
      this.enterpriseValue = enterpriseValue;
      return this;
    }

    public Builder withTrailingPE(double trailingPE) {
      this.trailingPE = trailingPE;
      return this;
    }

    public Builder withForwardPE(double forwardPE) {
      this.forwardPE = forwardPE;
      return this;
    }

    public Builder withPegRatio(double pegRatio) {
      this.pegRatio = pegRatio;
      return this;
    }

    public Builder withRatioPS(double ratioPS) {
      this.ratioPS = ratioPS;
      return this;
    }

    public Builder withRatioPB(double ratioPB) {
      this.ratioPB = ratioPB;
      return this;
    }

    public Builder withEvToRevenue(double evToRevenue) {
      this.evToRevenue = evToRevenue;
      return this;
    }

    public Builder withEvToEBITDA(double evToEBITDA) {
      this.evToEBITDA = evToEBITDA;
      return this;
    }

    public Builder withProfitMarginPercentage(double profitMarginPercentage) {
      this.profitMarginPercentage = profitMarginPercentage;
      return this;
    }

    public Builder withOperatingMarginPercentage(double operatingMarginPercentage) {
      this.operatingMarginPercentage = operatingMarginPercentage;
      return this;
    }

    public Builder withReturnOnAssetsPercentage(double returnOnAssetsPercentage) {
      this.returnOnAssetsPercentage = returnOnAssetsPercentage;
      return this;
    }

    public Builder withReturnOnEquityPercentage(double returnOnEquityPercentage) {
      this.returnOnEquityPercentage = returnOnEquityPercentage;
      return this;
    }

    public Builder withRevenue(String revenue) {
      this.revenue = revenue;
      return this;
    }

    public Builder withRevenuePerShare(double revenuePerShare) {
      this.revenuePerShare = revenuePerShare;
      return this;
    }

    public Builder withQuarterlyRevenueGrowthPercentage(double quarterlyRevenueGrowthPercentage) {
      this.quarterlyRevenueGrowthPercentage = quarterlyRevenueGrowthPercentage;
      return this;
    }

    public Builder withGrossProfit(double grossProfit) {
      this.grossProfit = grossProfit;
      return this;
    }

    public Builder withEBITDA(String EBITDA) {
      this.EBITDA = EBITDA;
      return this;
    }

    public Builder withNetIncomeAviToCommon(String netIncomeAviToCommon) {
      this.netIncomeAviToCommon = netIncomeAviToCommon;
      return this;
    }

    public Builder withDilutedEPS(double dilutedEPS) {
      this.dilutedEPS = dilutedEPS;
      return this;
    }

    public Builder withQuartEarningsGrowthPercentage(double quartEarningsGrowthPercentage) {
      this.quartEarningsGrowthPercentage = quartEarningsGrowthPercentage;
      return this;
    }

    public Builder withTotalCash(double totalCash) {
      this.totalCash = totalCash;
      return this;
    }

    public Builder withTotalCashPerShare(double totalCashPerShare) {
      this.totalCashPerShare = totalCashPerShare;
      return this;
    }

    public Builder withTotalDebt(String totalDebt) {
      this.totalDebt = totalDebt;
      return this;
    }

    public Builder withTotalDebtToEquityPercentage(double totalDebtToEquityPercentage) {
      this.totalDebtToEquityPercentage = totalDebtToEquityPercentage;
      return this;
    }

    public Builder withTradingInformation(CompanyTradingInformation tradingInformation) {
      this.tradingInformation = tradingInformation;
      return this;
    }

    @Override
    public CompanyKeyStatistics build() {
      return new CompanyKeyStatistics(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
