package org.opensource.model;

public class CompanyKeyStatistics {
  private String companyName;
  private String companyTicker;
  private double currentPrice;
  private String marketCap;
  private String enterpriseValue;
  private double trailingPE;
  private double forwardPE;
  private double pegRatio; // (5 yr expected)
  private double ratioPS;
  private double ratioPB;
  private double evToRevenue;
  private double evToEBITDA;
  private String profitMargin;
  private String operatingMargin;
  private String returnOnAssets;
  private String returnOnEquity;
  private String revenue;
  private String quarterlyRevenueGrowth;
  private String grossProfit;
  private String EBITDA;
  private double dilutedEPS;
  private String quartEarningsGrowth;
  private String totalCash;
  private double totalCashPerShare;
  private String totalDebt;
  private String totalDebtToEquity;
  private double beta;
  private String forwardAnnualDividendYield;
  private String payoutRatio;
  private String currentRatio;

  // Private constructor to prevent direct instantiation
  private CompanyKeyStatistics(Builder builder) {
    this.companyName = builder.companyName;
    this.companyTicker = builder.companyTicker;
    this.currentPrice = builder.currentPrice;
    this.marketCap = builder.marketCap;
    this.enterpriseValue = builder.enterpriseValue;
    this.trailingPE = builder.trailingPE;
    this.forwardPE = builder.forwardPE;
    this.pegRatio = builder.pegRatio;
    this.ratioPS = builder.ratioPS;
    this.ratioPB = builder.ratioPB;
    this.evToRevenue = builder.evToRevenue;
    this.evToEBITDA = builder.evToEBITDA;
    this.profitMargin = builder.profitMargin;
    this.operatingMargin = builder.operatingMargin;
    this.returnOnAssets = builder.returnOnAssets;
    this.returnOnEquity = builder.returnOnEquity;
    this.revenue = builder.revenue;
    this.quarterlyRevenueGrowth = builder.quarterlyRevenueGrowth;
    this.grossProfit = builder.grossProfit;
    this.EBITDA = builder.EBITDA;
    this.dilutedEPS = builder.dilutedEPS;
    this.quartEarningsGrowth = builder.quartEarningsGrowth;
    this.totalCash = builder.totalCash;
    this.totalCashPerShare = builder.totalCashPerShare;
    this.totalDebt = builder.totalDebt;
    this.totalDebtToEquity = builder.totalDebtToEquity;
    this.beta = builder.beta;
    this.forwardAnnualDividendYield = builder.forwardAnnualDividendYield;
    this.payoutRatio = builder.payoutRatio;
    this.currentRatio = builder.currentRatio;
  }

  // Static Builder class
  public static class Builder {
    private String companyName = "--";
    private String companyTicker = "--";
    private double currentPrice = 0.0;
    private String marketCap = "--";
    private String enterpriseValue = "--";
    private double trailingPE  = 0.0;
    private double forwardPE  = 0.0;
    private double pegRatio  = 0.0; // (5 yr expected)
    private double ratioPS  = 0.0;
    private double ratioPB  = 0.0;
    private double evToRevenue  = 0.0;
    private double evToEBITDA  = 0.0;
    private String profitMargin = "--";
    private String operatingMargin = "--";
    private String returnOnAssets = "--";
    private String returnOnEquity = "--";
    private String revenue = "--";
    private String quarterlyRevenueGrowth = "--";
    private String grossProfit = "--";
    private String EBITDA = "--";
    private double dilutedEPS  = 0.0;
    private String quartEarningsGrowth = "--";
    private String totalCash = "--";
    private double totalCashPerShare  = 0.0;
    private String totalDebt = "--";
    private String totalDebtToEquity = "--";
    private double beta  = 0.0;
    private String forwardAnnualDividendYield = "--";
    private String payoutRatio = "--";
    private String currentRatio = "--";

    public Builder withCompanyName(String companyName) {
      this.companyName = companyName;
      return this;
    }

    public Builder withCompanyTicker(String companyTicker) {
      this.companyTicker = companyTicker;
      return this;
    }

    public Builder withCurrentPrice(double currentPrice) {
      this.currentPrice = currentPrice;
      return this;
    }

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

    public Builder withProfitMargin(String profitMargin) {
      this.profitMargin = profitMargin;
      return this;
    }

    public Builder withOperatingMargin(String operatingMargin) {
      this.operatingMargin = operatingMargin;
      return this;
    }

    public Builder withReturnOnAssets(String returnOnAssets) {
      this.returnOnAssets = returnOnAssets;
      return this;
    }

    public Builder withReturnOnEquity(String returnOnEquity) {
      this.returnOnEquity = returnOnEquity;
      return this;
    }

    public Builder withRevenue(String revenue) {
      this.revenue = revenue;
      return this;
    }

    public Builder withQuarterlyRevenueGrowth(String quarterlyRevenueGrowth) {
      this.quarterlyRevenueGrowth = quarterlyRevenueGrowth;
      return this;
    }

    public Builder withGrossProfit(String grossProfit) {
      this.grossProfit = grossProfit;
      return this;
    }

    public Builder withEBITDA(String EBITDA) {
      this.EBITDA = EBITDA;
      return this;
    }

    public Builder withDilutedEPS(double dilutedEPS) {
      this.dilutedEPS = dilutedEPS;
      return this;
    }

    public Builder withQuartEarningsGrowth(String quartEarningsGrowth) {
      this.quartEarningsGrowth = quartEarningsGrowth;
      return this;
    }

    public Builder withTotalCash(String totalCash) {
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

    public Builder withTotalDebtToEquity(String totalDebtToEquity) {
      this.totalDebtToEquity = totalDebtToEquity;
      return this;
    }

    public Builder withBeta(double beta) {
      this.beta = beta;
      return this;
    }

    public Builder withForwardAnnualDividendYield(String forwardAnnualDividendYield) {
      this.forwardAnnualDividendYield = forwardAnnualDividendYield;
      return this;
    }

    public Builder withPayoutRatio(String payoutRatio) {
      this.payoutRatio = payoutRatio;
      return this;
    }

    public Builder withCurrentRatio(String currentRatio) {
      this.currentRatio = currentRatio;
      return this;
    }

    public CompanyKeyStatistics build() {
      return new CompanyKeyStatistics(this);
    }
  }
}
