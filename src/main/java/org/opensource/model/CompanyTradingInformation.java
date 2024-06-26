package org.opensource.model;

public class CompanyTradingInformation {
  private double beta;
  private String forwardAnnualDividendYield;
  private String payoutRatio;
  private String currentRatio;
  private String week52Range;
  private double week52High;
  private double week52Low;
  private double day50MovingAvg;
  private double day200MovingAverage;

  private CompanyTradingInformation(Builder builder) {
    this.beta = builder.beta;
    this.forwardAnnualDividendYield = builder.forwardAnnualDividendYield;
    this.payoutRatio = builder.payoutRatio;
    this.currentRatio = builder.currentRatio;
    this.week52Range = builder.week52Range;
    this.week52High = builder.week52High;
    this.week52Low = builder.week52Low;
    this.day50MovingAvg = builder.day50MovingAvg;
    this.day200MovingAverage = builder.day200MovingAverage;
  }

  public static class Builder {
    private double beta;
    private String forwardAnnualDividendYield;
    private String payoutRatio;
    private String currentRatio;
    private String week52Range;
    private double week52High;
    private double week52Low;
    private double day50MovingAvg;
    private double day200MovingAverage;

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

    public Builder withWeek52Range(String week52Range) {
      this.week52Range = week52Range;
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

    public CompanyTradingInformation build() {
      return new CompanyTradingInformation(this);
    }
  }
}

