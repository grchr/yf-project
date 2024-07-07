package org.opensource.model;

public class CompanyCashFlow extends AbstractCompanyInformation {
  private String operatingCashFlowTTM;
  private String investingCashFlowTTM;
  private String financingCashFlowTTM;
  private String endCashPositionTTM;
  private String capitalExpenditureTTM;
  private String freeCashFlowTTM;

  private CompanyCashFlow(Builder builder) {
    super(builder); // Calling the parent class constructor
    this.operatingCashFlowTTM = builder.operatingCashFlowTTM;
    this.investingCashFlowTTM = builder.investingCashFlowTTM;
    this.financingCashFlowTTM = builder.financingCashFlowTTM;
    this.endCashPositionTTM = builder.endCashPositionTTM;
    this.capitalExpenditureTTM = builder.capitalExpenditureTTM;
    this.freeCashFlowTTM = builder.freeCashFlowTTM;
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

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private String operatingCashFlowTTM = DEFAULT;
    private String investingCashFlowTTM = DEFAULT;
    private String financingCashFlowTTM = DEFAULT;
    private String endCashPositionTTM = DEFAULT;
    private String capitalExpenditureTTM = DEFAULT;
    private String freeCashFlowTTM = DEFAULT;

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
