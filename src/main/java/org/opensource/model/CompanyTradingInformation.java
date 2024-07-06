package org.opensource.model;

import java.util.Objects;

public class CompanyTradingInformation extends AbstractCompanyInformation{
  private String beta;
  private String forwardAnnualDividendYield;
  private String payoutRatio;
  private String currentRatio;
  private String week52Range;
  private String week52High;
  private String week52Low;
  private String day50MovingAvg;
  private String day200MovingAverage;

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

  public String getBeta() {
    return beta;
  }

  public String getForwardAnnualDividendYield() {
    return forwardAnnualDividendYield;
  }

  public String getPayoutRatio() {
    return payoutRatio;
  }

  public String getCurrentRatio() {
    return currentRatio;
  }

  public String getWeek52Range() {
    return week52Range;
  }

  public String getWeek52High() {
    return week52High;
  }

  public String getWeek52Low() {
    return week52Low;
  }

  public String getDay50MovingAvg() {
    return day50MovingAvg;
  }

  public String getDay200MovingAverage() {
    return day200MovingAverage;
  }

  @Override
  public String toString() {
    return "CompanyTradingInformation{" +
            "beta='" + beta + '\'' +
            ", forwardAnnualDividendYield='" + forwardAnnualDividendYield + '\'' +
            ", payoutRatio='" + payoutRatio + '\'' +
            ", currentRatio='" + currentRatio + '\'' +
            ", week52Range='" + week52Range + '\'' +
            ", week52High='" + week52High + '\'' +
            ", week52Low='" + week52Low + '\'' +
            ", day50MovingAvg='" + day50MovingAvg + '\'' +
            ", day200MovingAverage='" + day200MovingAverage + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyTradingInformation that)) return false;
    return Objects.equals(getBeta(), that.getBeta())
            && Objects.equals(getForwardAnnualDividendYield(), that.getForwardAnnualDividendYield())
            && Objects.equals(getPayoutRatio(), that.getPayoutRatio())
            && Objects.equals(getCurrentRatio(), that.getCurrentRatio())
            && Objects.equals(getWeek52Range(), that.getWeek52Range())
            && Objects.equals(getWeek52High(), that.getWeek52High())
            && Objects.equals(getWeek52Low(), that.getWeek52Low())
            && Objects.equals(getDay50MovingAvg(), that.getDay50MovingAvg())
            && Objects.equals(getDay200MovingAverage(), that.getDay200MovingAverage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBeta(),
            getForwardAnnualDividendYield(),
            getPayoutRatio(),
            getCurrentRatio(),
            getWeek52Range(),
            getWeek52High(),
            getWeek52Low(),
            getDay50MovingAvg(),
            getDay200MovingAverage());
  }

  public static class Builder extends AbstractCompanyInfoBuilder{
    private String beta;
    private String forwardAnnualDividendYield;
    private String payoutRatio;
    private String currentRatio;
    private String week52Range;
    private String week52High;
    private String week52Low;
    private String day50MovingAvg;
    private String day200MovingAverage;

    public Builder withBeta(String beta) {
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

    public Builder withWeek52High(String week52High) {
      this.week52High = week52High;
      return this;
    }

    public Builder withWeek52Low(String week52Low) {
      this.week52Low = week52Low;
      return this;
    }

    public Builder withDay50MovingAvg(String day50MovingAvg) {
      this.day50MovingAvg = day50MovingAvg;
      return this;
    }

    public Builder withDay200MovingAverage(String day200MovingAverage) {
      this.day200MovingAverage = day200MovingAverage;
      return this;
    }

    public CompanyTradingInformation build() {
      return new CompanyTradingInformation(this);
    }
  }
}

