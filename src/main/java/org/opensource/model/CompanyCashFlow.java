package org.opensource.model;

public class CompanyCashFlow extends AbstractCompanyInformation {
  private String operatingCashFlow;
  private String investingCashFlow;
  private String financingCashFlow;
  private String endCashPosition;
  private String capitalExpenditure;
  private String freeCashFlow;

  private CompanyCashFlow(Builder builder) {
    super(builder); // Calling the parent class constructor
    this.operatingCashFlow = builder.operatingCashFlow;
    this.investingCashFlow = builder.investingCashFlow;
    this.financingCashFlow = builder.financingCashFlow;
    this.endCashPosition = builder.endCashPosition;
    this.capitalExpenditure = builder.capitalExpenditure;
    this.freeCashFlow = builder.freeCashFlow;
  }

  public String getOperatingCashFlow() {
    return operatingCashFlow;
  }

  public String getInvestingCashFlow() {
    return investingCashFlow;
  }

  public String getFinancingCashFlow() {
    return financingCashFlow;
  }

  public String getEndCashPosition() {
    return endCashPosition;
  }

  public String getCapitalExpenditure() {
    return capitalExpenditure;
  }

  public String getFreeCashFlow() {
    return freeCashFlow;
  }

  public static class Builder extends AbstractCompanyInformation.Builder<Builder> {
    private String operatingCashFlow = DEFAULT;
    private String investingCashFlow = DEFAULT;
    private String financingCashFlow = DEFAULT;
    private String endCashPosition = DEFAULT;
    private String capitalExpenditure = DEFAULT;
    private String freeCashFlow = DEFAULT;

    public Builder withOperatingCashFlow(String operatingCashFlow) {
      this.operatingCashFlow = operatingCashFlow;
      return this;
    }

    public Builder withInvestingCashFlow(String investingCashFlow) {
      this.investingCashFlow = investingCashFlow;
      return this;
    }

    public Builder withFinancingCashFlow(String financingCashFlow) {
      this.financingCashFlow = financingCashFlow;
      return this;
    }

    public Builder withEndCashPosition(String endCashPosition) {
      this.endCashPosition = endCashPosition;
      return this;
    }

    public Builder withCapitalExpenditure(String capitalExpenditure) {
      this.capitalExpenditure = capitalExpenditure;
      return this;
    }

    public Builder withFreeCashFlow(String freeCashFlow) {
      this.freeCashFlow = freeCashFlow;
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
