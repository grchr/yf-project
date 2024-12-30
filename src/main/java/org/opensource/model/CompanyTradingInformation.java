package org.opensource.model;

import java.util.Objects;

public class CompanyTradingInformation extends AbstractCompanyInformation {
  private double beta;
  private double forwardAnnualDividendYieldPercentage;
  private double forwardAnnualDividendRate;
  private double dividendYield5YearAvg;
  private double trailingAnnualDividendYieldPercentage;
  private double trailingAnnualDividendRate;
  private double payoutRatioPercentage;
  private double currentRatio;
  private double week52RangePercentage;
  private double week52High;
  private double week52Low;
  private double day50MovingAvg;
  private double day200MovingAverage;
  private String dividendDate;
  private String exDividendDate;

  private CompanyTradingInformation(Builder builder) {
    super(builder);
    this.beta = builder.beta;
    this.forwardAnnualDividendYieldPercentage = builder.forwardAnnualDividendYieldPercentage;
    this.forwardAnnualDividendRate = builder.forwardAnnualDividendRate;
    this.dividendYield5YearAvg = builder.dividendYield5YearAvg;
    this.trailingAnnualDividendYieldPercentage = builder.trailingAnnualDividendYieldPercentage;
    this.trailingAnnualDividendRate = builder.trailingAnnualDividendRate;
    this.payoutRatioPercentage = builder.payoutRatioPercentage;
    this.currentRatio = builder.currentRatio;
    this.week52RangePercentage = builder.week52RangePercentage;
    this.week52High = builder.week52High;
    this.week52Low = builder.week52Low;
    this.day50MovingAvg = builder.day50MovingAvg;
    this.day200MovingAverage = builder.day200MovingAverage;
    this.dividendDate = builder.dividendDate;
    this.exDividendDate = builder.exDividendDate;
  }

  public double getBeta() {
    return beta;
  }

  public double getForwardAnnualDividendYieldPercentage() {
    return forwardAnnualDividendYieldPercentage;
  }

  public double getForwardAnnualDividendRate() {
    return forwardAnnualDividendRate;
  }

  public double getDividendYield5YearAvg() {
    return dividendYield5YearAvg;
  }

  public double getTrailingAnnualDividendYieldPercentage() {
    return trailingAnnualDividendYieldPercentage;
  }

  public double getTrailingAnnualDividendRate() {
    return trailingAnnualDividendRate;
  }

  public double getPayoutRatioPercentage() {
    return payoutRatioPercentage;
  }

  public double getCurrentRatio() {
    return currentRatio;
  }

  public double getWeek52RangePercentage() {
    return week52RangePercentage;
  }

  public double getWeek52High() {
    return week52High;
  }

  public String getDividendDate() {
    return dividendDate;
  }

  public String getExDividendDate() {
    return exDividendDate;
  }

  public double getWeek52Low() {
    return week52Low;
  }

  public double getDay50MovingAvg() {
    return day50MovingAvg;
  }

  public double getDay200MovingAverage() {
    return day200MovingAverage;
  }

  @Override
  public String toString() {
    return "CompanyTradingInformation{" +
        "companyName='" + companyName +
        ", companyTicker='" + companyTicker +
        ", currentPrice='" + currentPrice +
        ", beta=" + beta +
        ", forwardAnnualDividendYieldPercentage=" + forwardAnnualDividendYieldPercentage +
        ", forwardAnnualDividendRate=" + forwardAnnualDividendRate +
        ", dividendYield5YearAvg=" + dividendYield5YearAvg +
        ", trailingAnnualDividendYieldPercentage=" + trailingAnnualDividendYieldPercentage +
        ", trailingAnnualDividendRate=" + trailingAnnualDividendRate +
        ", payoutRatioPercentage=" + payoutRatioPercentage +
        ", currentRatio=" + currentRatio +
        ", week52RangePercentage=" + week52RangePercentage +
        ", week52High=" + week52High +
        ", week52Low=" + week52Low +
        ", day50MovingAvg=" + day50MovingAvg +
        ", day200MovingAverage=" + day200MovingAverage +
        ", dividendDate='" + dividendDate + '\'' +
        ", exDividendDate='" + exDividendDate + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CompanyTradingInformation that = (CompanyTradingInformation) o;
    return Double.compare(beta, that.beta) == 0
        && Double.compare(forwardAnnualDividendYieldPercentage, that.forwardAnnualDividendYieldPercentage) == 0
        && Double.compare(forwardAnnualDividendRate, that.forwardAnnualDividendRate) == 0
        && Double.compare(dividendYield5YearAvg, that.dividendYield5YearAvg) == 0
        && Double.compare(trailingAnnualDividendYieldPercentage, that.trailingAnnualDividendYieldPercentage) == 0
        && Double.compare(trailingAnnualDividendRate, that.trailingAnnualDividendRate) == 0
        && Double.compare(payoutRatioPercentage, that.payoutRatioPercentage) == 0
        && Double.compare(currentRatio, that.currentRatio) == 0
        && Double.compare(week52RangePercentage, that.week52RangePercentage) == 0
        && Double.compare(week52High, that.week52High) == 0
        && Double.compare(week52Low, that.week52Low) == 0
        && Double.compare(day50MovingAvg, that.day50MovingAvg) == 0
        && Double.compare(day200MovingAverage, that.day200MovingAverage) == 0
        && Objects.equals(dividendDate, that.dividendDate)
        && Objects.equals(exDividendDate, that.exDividendDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beta, forwardAnnualDividendYieldPercentage, forwardAnnualDividendRate,
        dividendYield5YearAvg, trailingAnnualDividendYieldPercentage, trailingAnnualDividendRate,
        payoutRatioPercentage, currentRatio, week52RangePercentage, week52High, week52Low, day50MovingAvg,
        day200MovingAverage, dividendDate, exDividendDate);
  }

  public static class Builder extends AbstractCompanyInformation.Builder<CompanyTradingInformation.Builder> {
    private double beta = DEFAULT_DOUBLE;
    private double forwardAnnualDividendYieldPercentage = DEFAULT_DOUBLE;
    private double forwardAnnualDividendRate = DEFAULT_DOUBLE;
    private double dividendYield5YearAvg = DEFAULT_DOUBLE;
    private double trailingAnnualDividendYieldPercentage = DEFAULT_DOUBLE;
    private double trailingAnnualDividendRate = DEFAULT_DOUBLE;
    private double payoutRatioPercentage = DEFAULT_DOUBLE;
    private double currentRatio = DEFAULT_DOUBLE;
    private double week52RangePercentage = DEFAULT_DOUBLE;
    private double week52High = DEFAULT_DOUBLE;
    private double week52Low = DEFAULT_DOUBLE;
    private double day50MovingAvg = DEFAULT_DOUBLE;
    private double day200MovingAverage = DEFAULT_DOUBLE;
    private String dividendDate = DEFAULT;
    private String exDividendDate = DEFAULT;

    public Builder withBeta(double beta) {
      this.beta = beta;
      return this;
    }

    public Builder withForwardAnnualDividendYieldPercentage(double forwardAnnualDividendYieldPercentage) {
      this.forwardAnnualDividendYieldPercentage = forwardAnnualDividendYieldPercentage;
      return this;
    }

    public Builder withForwardAnnualDividendRate(double forwardAnnualDividendRate) {
      this.forwardAnnualDividendRate = forwardAnnualDividendRate;
      return this;
    }

    public Builder withDividendYield5YearAvg(double dividendYield5YearAvg) {
      this.dividendYield5YearAvg = dividendYield5YearAvg;
      return this;
    }

    public Builder withTrailingAnnualDividendYieldPercentage(double trailingAnnualDividendYieldPercentage) {
      this.trailingAnnualDividendYieldPercentage = trailingAnnualDividendYieldPercentage;
      return this;
    }

    public Builder withTrailingAnnualDividendRate(double trailingAnnualDividendRate) {
      this.trailingAnnualDividendRate = trailingAnnualDividendRate;
      return this;
    }

    public Builder withPayoutRatioPercentage(double payoutRatioPercentage) {
      this.payoutRatioPercentage = payoutRatioPercentage;
      return this;
    }

    public Builder withCurrentRatio(double currentRatio) {
      this.currentRatio = currentRatio;
      return this;
    }

    public Builder withWeek52RangePercentage(double week52RangePercentage) {
      this.week52RangePercentage = week52RangePercentage;
      return this;
    }

    public Builder withWeek52High(double week52High) {
      this.week52High = week52High;
      return this;
    }

    public Builder withWeek52Low(double week52Low) {
      this.week52Low = week52Low;
      return this;
    }

    public Builder withDay50MovingAvg(double day50MovingAvg) {
      this.day50MovingAvg = day50MovingAvg;
      return this;
    }

    public Builder withDay200MovingAverage(double day200MovingAverage) {
      this.day200MovingAverage = day200MovingAverage;
      return this;
    }

    public Builder withDividendDate(String dividendDate) {
      this.dividendDate = dividendDate;
      return this;
    }

    public Builder withExDividendDate(String exDividendDate) {
      this.exDividendDate = exDividendDate;
      return this;
    }

    @Override
    public CompanyTradingInformation build() {
      return new CompanyTradingInformation(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
