package org.opensource.model;

import java.util.Objects;

public class CompanyCashFlow extends AbstractCompanyInformation {

  private String operatingCashFlowTTM;
  private String operatingCashFlowLastUpdate;

  private String investingCashFlowTTM;
  private String investingCashFlowLastUpdate;

  private String financingCashFlowTTM;
  private String financingCashFlowLastUpdate;

  private String endCashPositionTTM;
  private String endCashPositionLastUpdate;

  private String capitalExpenditureTTM;
  private String capitalExpenditureLastUpdate;

  private String freeCashFlowTTM;
  private String freeCashFlowLastUpdate;

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

  public String getOperatingCashFlowTTM() {
    return operatingCashFlowTTM;
  }

  public String getInvestingCashFlowTTM() {
    return investingCashFlowTTM;
  }

  public String getFinancingCashFlowTTM() {
    return financingCashFlowTTM;
  }

  public String getEndCashPositionTTM() {
    return endCashPositionTTM;
  }

  public String getCapitalExpenditureTTM() {
    return capitalExpenditureTTM;
  }

  public String getFreeCashFlowTTM() {
    return freeCashFlowTTM;
  }

  public String getOperatingCashFlowLastUpdate() {
    return operatingCashFlowLastUpdate;
  }

  public String getInvestingCashFlowLastUpdate() {
    return investingCashFlowLastUpdate;
  }

  public String getFinancingCashFlowLastUpdate() {
    return financingCashFlowLastUpdate;
  }

  public String getEndCashPositionLastUpdate() {
    return endCashPositionLastUpdate;
  }

  public String getCapitalExpenditureLastUpdate() {
    return capitalExpenditureLastUpdate;
  }

  public String getFreeCashFlowLastUpdate() {
    return freeCashFlowLastUpdate;
  }

  @Override
  public String toString() {
    return "CompanyCashFlow{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", operatingCashFlowTTM='" + operatingCashFlowTTM + '\'' +
            ", investingCashFlowTTM='" + investingCashFlowTTM + '\'' +
            ", financingCashFlowTTM='" + financingCashFlowTTM + '\'' +
            ", endCashPositionTTM='" + endCashPositionTTM + '\'' +
            ", capitalExpenditureTTM='" + capitalExpenditureTTM + '\'' +
            ", freeCashFlowTTM='" + freeCashFlowTTM + '\'' +
            ", operatingCashFlowLastUpdate='" + operatingCashFlowLastUpdate + '\'' +
            ", investingCashFlowLastUpdate='" + investingCashFlowLastUpdate + '\'' +
            ", financingCashFlowLastUpdate='" + financingCashFlowLastUpdate + '\'' +
            ", endCashPositionLastUpdate='" + endCashPositionLastUpdate + '\'' +
            ", capitalExpenditureLastUpdate='" + capitalExpenditureLastUpdate + '\'' +
            ", freeCashFlowLastUpdate='" + freeCashFlowLastUpdate + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyCashFlow that)) return false;
    return Objects.equals(getOperatingCashFlowTTM(), that.getOperatingCashFlowTTM())
            && Objects.equals(getInvestingCashFlowTTM(), that.getInvestingCashFlowTTM())
            && Objects.equals(getFinancingCashFlowTTM(), that.getFinancingCashFlowTTM())
            && Objects.equals(getEndCashPositionTTM(), that.getEndCashPositionTTM())
            && Objects.equals(getCapitalExpenditureTTM(), that.getCapitalExpenditureTTM())
            && Objects.equals(getFreeCashFlowTTM(), that.getFreeCashFlowTTM())
            && Objects.equals(getOperatingCashFlowLastUpdate(), that.getOperatingCashFlowLastUpdate())
            && Objects.equals(getInvestingCashFlowLastUpdate(), that.getInvestingCashFlowLastUpdate())
            && Objects.equals(getFinancingCashFlowLastUpdate(), that.getFinancingCashFlowLastUpdate())
            && Objects.equals(getEndCashPositionLastUpdate(), that.getEndCashPositionLastUpdate())
            && Objects.equals(getCapitalExpenditureLastUpdate(), that.getCapitalExpenditureLastUpdate())
            && Objects.equals(getFreeCashFlowLastUpdate(), that.getFreeCashFlowLastUpdate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOperatingCashFlowTTM(),
            getInvestingCashFlowTTM(),
            getFinancingCashFlowTTM(),
            getEndCashPositionTTM(),
            getCapitalExpenditureTTM(),
            getFreeCashFlowTTM(),
            getOperatingCashFlowLastUpdate(),
            getInvestingCashFlowLastUpdate(),
            getFinancingCashFlowLastUpdate(),
            getEndCashPositionLastUpdate(),
            getCapitalExpenditureLastUpdate(),
            getFreeCashFlowLastUpdate());
  }

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private String operatingCashFlowTTM = DEFAULT;
    private String investingCashFlowTTM = DEFAULT;
    private String financingCashFlowTTM = DEFAULT;
    private String endCashPositionTTM = DEFAULT;
    private String capitalExpenditureTTM = DEFAULT;
    private String freeCashFlowTTM = DEFAULT;
    private String operatingCashFlowLastUpdate = DEFAULT;
    private String investingCashFlowLastUpdate = DEFAULT;
    private String financingCashFlowLastUpdate = DEFAULT;
    private String endCashPositionLastUpdate = DEFAULT;
    private String capitalExpenditureLastUpdate = DEFAULT;
    private String freeCashFlowLastUpdate = DEFAULT;

    public Builder withOperatingCashFlowTTM(String operatingCashFlowTTM) {
      this.operatingCashFlowTTM = operatingCashFlowTTM;
      return this;
    }

    public Builder withInvestingCashFlowTTM(String investingCashFlowTTM) {
      this.investingCashFlowTTM = investingCashFlowTTM;
      return this;
    }

    public Builder withFinancingCashFlowTTM(String financingCashFlowTTM) {
      this.financingCashFlowTTM = financingCashFlowTTM;
      return this;
    }

    public Builder withEndCashPositionTTM(String endCashPositionTTM) {
      this.endCashPositionTTM = endCashPositionTTM;
      return this;
    }

    public Builder withCapitalExpenditureTTM(String capitalExpenditureTTM) {
      this.capitalExpenditureTTM = capitalExpenditureTTM;
      return this;
    }

    public Builder withFreeCashFlowTTM(String freeCashFlowTTM) {
      this.freeCashFlowTTM = freeCashFlowTTM;
      return this;
    }

    public Builder withOperatingCashFlowLastUpdate(String operatingCashFlowLastUpdate) {
      this.operatingCashFlowLastUpdate = operatingCashFlowLastUpdate;
      return this;
    }

    public Builder withInvestingCashFlowLastUpdate(String investingCashFlowLastUpdate) {
      this.investingCashFlowLastUpdate = investingCashFlowLastUpdate;
      return this;
    }

    public Builder withFinancingCashFlowLastUpdate(String financingCashFlowLastUpdate) {
      this.financingCashFlowLastUpdate = financingCashFlowLastUpdate;
      return this;
    }

    public Builder withEndCashPositionLastUpdate(String endCashPositionLastUpdate) {
      this.endCashPositionLastUpdate = endCashPositionLastUpdate;
      return this;
    }

    public Builder withCapitalExpenditureLastUpdate(String capitalExpenditureLastUpdate) {
      this.capitalExpenditureLastUpdate = capitalExpenditureLastUpdate;
      return this;
    }

    public Builder withFreeCashFlowLastUpdate(String freeCashFlowLastUpdate) {
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
