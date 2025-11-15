package org.opensource.model;

import java.util.Objects;

public class CompanyCashFlow extends AbstractCompanyInformation {

  private double operatingCashFlowTTM;
  private double investingCashFlowTTM;
  private double financingCashFlowTTM;
  private double endCashPositionTTM;
  private double capitalExpenditureTTM;
  private double freeCashFlowTTM;

  private double operatingCashFlowLastUpdate;
  private double investingCashFlowLastUpdate;
  private double financingCashFlowLastUpdate;
  private double endCashPositionLastUpdate;
  private double capitalExpenditureLastUpdate;
  private double freeCashFlowLastUpdate;

  private CompanyCashFlow(Builder builder) {
    super(builder); // Calling the parent class constructor
    this.operatingCashFlowTTM = builder.operatingCashFlowTTM;
    this.investingCashFlowTTM = builder.investingCashFlowTTM;
    this.financingCashFlowTTM = builder.financingCashFlowTTM;
    this.endCashPositionTTM = builder.endCashPositionTTM;
    this.capitalExpenditureTTM = builder.capitalExpenditureTTM;
    this.freeCashFlowTTM = builder.freeCashFlowTTM;

    this.operatingCashFlowLastUpdate = builder.operatingCashFlowLastUpdate;
    this.investingCashFlowLastUpdate = builder.investingCashFlowLastUpdate;
    this.financingCashFlowLastUpdate = builder.financingCashFlowLastUpdate;
    this.endCashPositionLastUpdate = builder.endCashPositionLastUpdate;
    this.capitalExpenditureLastUpdate = builder.capitalExpenditureLastUpdate;
    this.freeCashFlowLastUpdate = builder.freeCashFlowLastUpdate;
  }

  public double getOperatingCashFlowTTM() {
    return operatingCashFlowTTM;
  }

  public double getInvestingCashFlowTTM() {
    return investingCashFlowTTM;
  }

  public double getFinancingCashFlowTTM() {
    return financingCashFlowTTM;
  }

  public double getEndCashPositionTTM() {
    return endCashPositionTTM;
  }

  public double getCapitalExpenditureTTM() {
    return capitalExpenditureTTM;
  }

  public double getFreeCashFlowTTM() {
    return freeCashFlowTTM;
  }

  public double getOperatingCashFlowLastUpdate() {
    return operatingCashFlowLastUpdate;
  }

  public double getInvestingCashFlowLastUpdate() {
    return investingCashFlowLastUpdate;
  }

  public double getFinancingCashFlowLastUpdate() {
    return financingCashFlowLastUpdate;
  }

  public double getEndCashPositionLastUpdate() {
    return endCashPositionLastUpdate;
  }

  public double getCapitalExpenditureLastUpdate() {
    return capitalExpenditureLastUpdate;
  }

  public double getFreeCashFlowLastUpdate() {
    return freeCashFlowLastUpdate;
  }

  @Override
  public String toString() {
    return "CompanyCashFlow{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", operatingCashFlowTTM=" + operatingCashFlowTTM +
            ", investingCashFlowTTM=" + investingCashFlowTTM +
            ", financingCashFlowTTM=" + financingCashFlowTTM +
            ", endCashPositionTTM=" + endCashPositionTTM +
            ", capitalExpenditureTTM=" + capitalExpenditureTTM +
            ", freeCashFlowTTM=" + freeCashFlowTTM +
            ", operatingCashFlowLastUpdate=" + operatingCashFlowLastUpdate +
            ", investingCashFlowLastUpdate=" + investingCashFlowLastUpdate +
            ", financingCashFlowLastUpdate=" + financingCashFlowLastUpdate +
            ", endCashPositionLastUpdate=" + endCashPositionLastUpdate +
            ", capitalExpenditureLastUpdate=" + capitalExpenditureLastUpdate +
            ", freeCashFlowLastUpdate=" + freeCashFlowLastUpdate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyCashFlow that)) return false;
    return Double.compare(that.operatingCashFlowTTM, operatingCashFlowTTM) == 0 &&
            Double.compare(that.investingCashFlowTTM, investingCashFlowTTM) == 0 &&
            Double.compare(that.financingCashFlowTTM, financingCashFlowTTM) == 0 &&
            Double.compare(that.endCashPositionTTM, endCashPositionTTM) == 0 &&
            Double.compare(that.capitalExpenditureTTM, capitalExpenditureTTM) == 0 &&
            Double.compare(that.freeCashFlowTTM, freeCashFlowTTM) == 0 &&
            Double.compare(that.operatingCashFlowLastUpdate, operatingCashFlowLastUpdate) == 0 &&
            Double.compare(that.investingCashFlowLastUpdate, investingCashFlowLastUpdate) == 0 &&
            Double.compare(that.financingCashFlowLastUpdate, financingCashFlowLastUpdate) == 0 &&
            Double.compare(that.endCashPositionLastUpdate, endCashPositionLastUpdate) == 0 &&
            Double.compare(that.capitalExpenditureLastUpdate, capitalExpenditureLastUpdate) == 0 &&
            Double.compare(that.freeCashFlowLastUpdate, freeCashFlowLastUpdate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(operatingCashFlowTTM, investingCashFlowTTM, financingCashFlowTTM,
            endCashPositionTTM, capitalExpenditureTTM, freeCashFlowTTM,
            operatingCashFlowLastUpdate, investingCashFlowLastUpdate,
            financingCashFlowLastUpdate, endCashPositionLastUpdate,
            capitalExpenditureLastUpdate, freeCashFlowLastUpdate);
  }

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private double operatingCashFlowTTM = DEFAULT_DOUBLE;
    private double investingCashFlowTTM = DEFAULT_DOUBLE;
    private double financingCashFlowTTM = DEFAULT_DOUBLE;
    private double endCashPositionTTM = DEFAULT_DOUBLE;
    private double capitalExpenditureTTM = DEFAULT_DOUBLE;
    private double freeCashFlowTTM = DEFAULT_DOUBLE;

    private double operatingCashFlowLastUpdate = DEFAULT_DOUBLE;
    private double investingCashFlowLastUpdate = DEFAULT_DOUBLE;
    private double financingCashFlowLastUpdate = DEFAULT_DOUBLE;
    private double endCashPositionLastUpdate = DEFAULT_DOUBLE;
    private double capitalExpenditureLastUpdate = DEFAULT_DOUBLE;
    private double freeCashFlowLastUpdate = DEFAULT_DOUBLE;

    public Builder withOperatingCashFlowTTM(double operatingCashFlowTTM) {
      this.operatingCashFlowTTM = operatingCashFlowTTM;
      return this;
    }

    public Builder withInvestingCashFlowTTM(double investingCashFlowTTM) {
      this.investingCashFlowTTM = investingCashFlowTTM;
      return this;
    }

    public Builder withFinancingCashFlowTTM(double financingCashFlowTTM) {
      this.financingCashFlowTTM = financingCashFlowTTM;
      return this;
    }

    public Builder withEndCashPositionTTM(double endCashPositionTTM) {
      this.endCashPositionTTM = endCashPositionTTM;
      return this;
    }

    public Builder withCapitalExpenditureTTM(double capitalExpenditureTTM) {
      this.capitalExpenditureTTM = capitalExpenditureTTM;
      return this;
    }

    public Builder withFreeCashFlowTTM(double freeCashFlowTTM) {
      this.freeCashFlowTTM = freeCashFlowTTM;
      return this;
    }

    public Builder withOperatingCashFlowLastUpdate(double operatingCashFlowLastUpdate) {
      this.operatingCashFlowLastUpdate = operatingCashFlowLastUpdate;
      return this;
    }

    public Builder withInvestingCashFlowLastUpdate(double investingCashFlowLastUpdate) {
      this.investingCashFlowLastUpdate = investingCashFlowLastUpdate;
      return this;
    }

    public Builder withFinancingCashFlowLastUpdate(double financingCashFlowLastUpdate) {
      this.financingCashFlowLastUpdate = financingCashFlowLastUpdate;
      return this;
    }

    public Builder withEndCashPositionLastUpdate(double endCashPositionLastUpdate) {
      this.endCashPositionLastUpdate = endCashPositionLastUpdate;
      return this;
    }

    public Builder withCapitalExpenditureLastUpdate(double capitalExpenditureLastUpdate) {
      this.capitalExpenditureLastUpdate = capitalExpenditureLastUpdate;
      return this;
    }

    public Builder withFreeCashFlowLastUpdate(double freeCashFlowLastUpdate) {
      this.freeCashFlowLastUpdate = freeCashFlowLastUpdate;
      return this;
    }

    @Override
    public CompanyCashFlow build() {
      return new CompanyCashFlow(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
