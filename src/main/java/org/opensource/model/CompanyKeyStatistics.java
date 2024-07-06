package org.opensource.model;

import java.util.Objects;

public class CompanyKeyStatistics extends AbstractCompanyInformation {
  private String companyName;
  private String companyTicker;
  private String currentPrice;
  private String marketCap;
  private String enterpriseValue;
  private String trailingPE;
  private String forwardPE;
  private String pegRatio;
  private String ratioPS;
  private String ratioPB;
  private String evToRevenue;
  private String evToEBITDA;
  private String profitMargin;
  private String operatingMargin;
  private String returnOnAssets;
  private String returnOnEquity;
  private String revenue;
  private String revenuePerShare;
  private String quarterlyRevenueGrowth;
  private String grossProfit;
  private String EBITDA;
  private String netIncomeAviToCommon;
  private String dilutedEPS;
  private String quartEarningsGrowth;
  private String totalCash;
  private String totalCashPerShare;
  private String totalDebt;
  private String totalDebtToEquity;
  private CompanyTradingInformation tradingInformation;

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
    this.revenuePerShare = builder.revenuePerShare;
    this.quarterlyRevenueGrowth = builder.quarterlyRevenueGrowth;
    this.grossProfit = builder.grossProfit;
    this.EBITDA = builder.EBITDA;
    this.netIncomeAviToCommon = builder.netIncomeAviToCommon;
    this.dilutedEPS = builder.dilutedEPS;
    this.quartEarningsGrowth = builder.quartEarningsGrowth;
    this.totalCash = builder.totalCash;
    this.totalCashPerShare = builder.totalCashPerShare;
    this.totalDebt = builder.totalDebt;
    this.totalDebtToEquity = builder.totalDebtToEquity;
    this.tradingInformation = builder.tradingInformation;
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

  public String getMarketCap() {
    return marketCap;
  }

  public String getEnterpriseValue() {
    return enterpriseValue;
  }

  public String getTrailingPE() {
    return trailingPE;
  }

  public String getForwardPE() {
    return forwardPE;
  }

  public String getPegRatio() {
    return pegRatio;
  }

  public String getRatioPS() {
    return ratioPS;
  }

  public String getRatioPB() {
    return ratioPB;
  }

  public String getEvToRevenue() {
    return evToRevenue;
  }

  public String getEvToEBITDA() {
    return evToEBITDA;
  }

  public String getProfitMargin() {
    return profitMargin;
  }

  public String getOperatingMargin() {
    return operatingMargin;
  }

  public String getReturnOnAssets() {
    return returnOnAssets;
  }

  public String getReturnOnEquity() {
    return returnOnEquity;
  }

  public String getRevenue() {
    return revenue;
  }

  public String getRevenuePerShare() {
    return revenuePerShare;
  }

  public String getQuarterlyRevenueGrowth() {
    return quarterlyRevenueGrowth;
  }

  public String getGrossProfit() {
    return grossProfit;
  }

  public String getEBITDA() {
    return EBITDA;
  }

  public String getNetIncomeAviToCommon() {
    return netIncomeAviToCommon;
  }

  public String getDilutedEPS() {
    return dilutedEPS;
  }

  public String getQuartEarningsGrowth() {
    return quartEarningsGrowth;
  }

  public String getTotalCash() {
    return totalCash;
  }

  public String getTotalCashPerShare() {
    return totalCashPerShare;
  }

  public String getTotalDebt() {
    return totalDebt;
  }

  public String getTotalDebtToEquity() {
    return totalDebtToEquity;
  }

  public CompanyTradingInformation getTradingInformation() {
    return tradingInformation;
  }

  @Override
  public String toString() {
    return "CompanyKeyStatistics{" +
            "companyName='" + companyName + '\'' +
            ", companyTicker='" + companyTicker + '\'' +
            ", currentPrice='" + currentPrice + '\'' +
            ", marketCap='" + marketCap + '\'' +
            ", enterpriseValue='" + enterpriseValue + '\'' +
            ", trailingPE='" + trailingPE + '\'' +
            ", forwardPE='" + forwardPE + '\'' +
            ", pegRatio='" + pegRatio + '\'' +
            ", ratioPS='" + ratioPS + '\'' +
            ", ratioPB='" + ratioPB + '\'' +
            ", evToRevenue='" + evToRevenue + '\'' +
            ", evToEBITDA='" + evToEBITDA + '\'' +
            ", profitMargin='" + profitMargin + '\'' +
            ", operatingMargin='" + operatingMargin + '\'' +
            ", returnOnAssets='" + returnOnAssets + '\'' +
            ", returnOnEquity='" + returnOnEquity + '\'' +
            ", revenue='" + revenue + '\'' +
            ", revenuePerShare='" + revenuePerShare + '\'' +
            ", quarterlyRevenueGrowth='" + quarterlyRevenueGrowth + '\'' +
            ", grossProfit='" + grossProfit + '\'' +
            ", EBITDA='" + EBITDA + '\'' +
            ", netIncomeAviToCommon='" + netIncomeAviToCommon + '\'' +
            ", dilutedEPS='" + dilutedEPS + '\'' +
            ", quartEarningsGrowth='" + quartEarningsGrowth + '\'' +
            ", totalCash='" + totalCash + '\'' +
            ", totalCashPerShare='" + totalCashPerShare + '\'' +
            ", totalDebt='" + totalDebt + '\'' +
            ", totalDebtToEquity='" + totalDebtToEquity + '\'' +
            ", tradingInformation=" + tradingInformation +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyKeyStatistics that)) return false;
    return Objects.equals(getCompanyName(), that.getCompanyName())
            && Objects.equals(getCompanyTicker(), that.getCompanyTicker())
            && Objects.equals(getCurrentPrice(), that.getCurrentPrice())
            && Objects.equals(getMarketCap(), that.getMarketCap())
            && Objects.equals(getEnterpriseValue(), that.getEnterpriseValue())
            && Objects.equals(getTrailingPE(), that.getTrailingPE())
            && Objects.equals(getForwardPE(), that.getForwardPE())
            && Objects.equals(getPegRatio(), that.getPegRatio())
            && Objects.equals(getRatioPS(), that.getRatioPS())
            && Objects.equals(getRatioPB(), that.getRatioPB())
            && Objects.equals(getEvToRevenue(), that.getEvToRevenue())
            && Objects.equals(getEvToEBITDA(), that.getEvToEBITDA())
            && Objects.equals(getProfitMargin(), that.getProfitMargin())
            && Objects.equals(getOperatingMargin(), that.getOperatingMargin())
            && Objects.equals(getReturnOnAssets(), that.getReturnOnAssets())
            && Objects.equals(getReturnOnEquity(), that.getReturnOnEquity())
            && Objects.equals(getRevenue(), that.getRevenue())
            && Objects.equals(getRevenuePerShare(), that.getRevenuePerShare())
            && Objects.equals(getQuarterlyRevenueGrowth(), that.getQuarterlyRevenueGrowth())
            && Objects.equals(getGrossProfit(), that.getGrossProfit())
            && Objects.equals(getEBITDA(), that.getEBITDA())
            && Objects.equals(getNetIncomeAviToCommon(), that.getNetIncomeAviToCommon())
            && Objects.equals(getDilutedEPS(), that.getDilutedEPS())
            && Objects.equals(getQuartEarningsGrowth(), that.getQuartEarningsGrowth())
            && Objects.equals(getTotalCash(), that.getTotalCash())
            && Objects.equals(getTotalCashPerShare(), that.getTotalCashPerShare())
            && Objects.equals(getTotalDebt(), that.getTotalDebt())
            && Objects.equals(getTotalDebtToEquity(), that.getTotalDebtToEquity())
            && Objects.equals(getTradingInformation(), that.getTradingInformation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCompanyName(),
            getCompanyTicker(),
            getCurrentPrice(),
            getMarketCap(),
            getEnterpriseValue(),
            getTrailingPE(),
            getForwardPE(),
            getPegRatio(),
            getRatioPS(),
            getRatioPB(),
            getEvToRevenue(),
            getEvToEBITDA(),
            getProfitMargin(),
            getOperatingMargin(),
            getReturnOnAssets(),
            getReturnOnEquity(),
            getRevenue(),
            getRevenuePerShare(),
            getQuarterlyRevenueGrowth(),
            getGrossProfit(),
            getEBITDA(),
            getNetIncomeAviToCommon(),
            getDilutedEPS(),
            getQuartEarningsGrowth(),
            getTotalCash(),
            getTotalCashPerShare(),
            getTotalDebt(),
            getTotalDebtToEquity(),
            getTradingInformation());
  }

  public static class Builder extends AbstractCompanyInfoBuilder{
    private String companyName = "--";
    private String companyTicker = "--";
    private String currentPrice = "--";
    private String marketCap = "--";
    private String enterpriseValue = "--";
    private String trailingPE = "--";
    private String forwardPE = "--";
    private String pegRatio = "--";
    private String ratioPS = "--";
    private String ratioPB = "--";
    private String evToRevenue = "--";
    private String evToEBITDA = "--";
    private String profitMargin = "--";
    private String operatingMargin = "--";
    private String returnOnAssets = "--";
    private String returnOnEquity = "--";
    private String revenue = "--";
    private String revenuePerShare = "--";
    private String quarterlyRevenueGrowth = "--";
    private String grossProfit = "--";
    private String EBITDA = "--";
    private String netIncomeAviToCommon = "--";
    private String dilutedEPS = "--";
    private String quartEarningsGrowth = "--";
    private String totalCash = "--";
    private String totalCashPerShare = "--";
    private String totalDebt = "--";
    private String totalDebtToEquity = "--";
    private CompanyTradingInformation tradingInformation = new CompanyTradingInformation.Builder().build();

    public Builder withCompanyName(String companyName) {
      this.companyName = companyName;
      return this;
    }

    public Builder withCompanyTicker(String companyTicker) {
      this.companyTicker = companyTicker;
      return this;
    }

    public Builder withCurrentPrice(String currentPrice) {
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

    public Builder withTrailingPE(String trailingPE) {
      this.trailingPE = trailingPE;
      return this;
    }

    public Builder withForwardPE(String forwardPE) {
      this.forwardPE = forwardPE;
      return this;
    }

    public Builder withPegRatio(String pegRatio) {
      this.pegRatio = pegRatio;
      return this;
    }

    public Builder withRatioPS(String ratioPS) {
      this.ratioPS = ratioPS;
      return this;
    }

    public Builder withRatioPB(String ratioPB) {
      this.ratioPB = ratioPB;
      return this;
    }

    public Builder withEvToRevenue(String evToRevenue) {
      this.evToRevenue = evToRevenue;
      return this;
    }

    public Builder withEvToEBITDA(String evToEBITDA) {
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

    public Builder withRevenuePerShare(String revenuePerShare) {
      this.revenuePerShare = revenuePerShare;
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

    public Builder withNetIncomeAviToCommon(String netIncomeAviToCommon) {
      this.netIncomeAviToCommon = netIncomeAviToCommon;
      return this;
    }

    public Builder withDilutedEPS(String dilutedEPS) {
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

    public Builder withTotalCashPerShare(String totalCashPerShare) {
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

    public Builder withTradingInformation(CompanyTradingInformation tradingInformation) {
      this.tradingInformation = tradingInformation;
      return this;
    }

    @Override
    public CompanyKeyStatistics build() {
      return new CompanyKeyStatistics(this);
    }

    @Override
    public CompanyKeyStatistics.Builder self(){
      return this;
    }
  }
}

