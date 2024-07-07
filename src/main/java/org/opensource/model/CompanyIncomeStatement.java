package org.opensource.model;

import java.util.Objects;

public class CompanyIncomeStatement extends AbstractCompanyInformation {

  // Total Revenue
  private final String totalRevenueTTM;
  private final String totalRevenueLastUpdate;

  // Pretax Income
  private final String pretaxIncomeTTM;
  private final String pretaxIncomeLastUpdate;

  // Tax Provision
  private final String taxProvisionTTM;
  private final String taxProvisionLastUpdate;

  // Net Income Common Stockholders
  private final String netIncomeCommonStockholdersTTM;
  private final String netIncomeCommonStockholdersLastUpdate;

  // Basic EPS (Earnings Per Share)
  private final String basicEPSTTM;
  private final String basicEPSLastUpdate;

  // Diluted EPS
  private final String dilutedEPSTTM;
  private final String dilutedEPSLastUpdate;

  // Basic Average Shares
  private final String basicAvgSharesTTM;
  private final String basicAvgSharesLastUpdate;

  // Diluted Average Shares
  private final String dilutedAvgSharesTTM;
  private final String dilutedAvgSharesLastUpdate;

  // Net Income from Continuing & Discontinued Operations
  private final String netIncomeContinuingDiscontinuedOpsTTM;
  private final String netIncomeContinuingDiscontinuedOpsLastUpdate;

  // Normalized Income
  private final String normalizedIncomeTTM;
  private final String normalizedIncomeLastUpdate;

  private CompanyIncomeStatement(Builder builder) {
    super(builder);
    this.totalRevenueTTM = builder.totalRevenueTTM;
    this.totalRevenueLastUpdate = builder.totalRevenueLastUpdate;
    this.pretaxIncomeTTM = builder.pretaxIncomeTTM;
    this.pretaxIncomeLastUpdate = builder.pretaxIncomeLastUpdate;
    this.taxProvisionTTM = builder.taxProvisionTTM;
    this.taxProvisionLastUpdate = builder.taxProvisionLastUpdate;
    this.netIncomeCommonStockholdersTTM = builder.netIncomeCommonStockholdersTTM;
    this.netIncomeCommonStockholdersLastUpdate = builder.netIncomeCommonStockholdersLastUpdate;
    this.basicEPSTTM = builder.basicEPSTTM;
    this.basicEPSLastUpdate = builder.basicEPSLastUpdate;
    this.dilutedEPSTTM = builder.dilutedEPSTTM;
    this.dilutedEPSLastUpdate = builder.dilutedEPSLastUpdate;
    this.basicAvgSharesTTM = builder.basicAvgSharesTTM;
    this.basicAvgSharesLastUpdate = builder.basicAvgSharesLastUpdate;
    this.dilutedAvgSharesTTM = builder.dilutedAvgSharesTTM;
    this.dilutedAvgSharesLastUpdate = builder.dilutedAvgSharesLastUpdate;
    this.netIncomeContinuingDiscontinuedOpsTTM = builder.netIncomeContinuingDiscontinuedOpsTTM;
    this.netIncomeContinuingDiscontinuedOpsLastUpdate = builder.netIncomeContinuingDiscontinuedOpsLastUpdate;
    this.normalizedIncomeTTM = builder.normalizedIncomeTTM;
    this.normalizedIncomeLastUpdate = builder.normalizedIncomeLastUpdate;
  }

  // Getters
  public String getTotalRevenueTTM() {
    return totalRevenueTTM;
  }

  public String getTotalRevenueLastUpdate() {
    return totalRevenueLastUpdate;
  }

  public String getPretaxIncomeTTM() {
    return pretaxIncomeTTM;
  }

  public String getPretaxIncomeLastUpdate() {
    return pretaxIncomeLastUpdate;
  }

  public String getTaxProvisionTTM() {
    return taxProvisionTTM;
  }

  public String getTaxProvisionLastUpdate() {
    return taxProvisionLastUpdate;
  }

  public String getNetIncomeCommonStockholdersTTM() {
    return netIncomeCommonStockholdersTTM;
  }

  public String getNetIncomeCommonStockholdersLastUpdate() {
    return netIncomeCommonStockholdersLastUpdate;
  }

  public String getBasicEPSTTM() {
    return basicEPSTTM;
  }

  public String getBasicEPSLastUpdate() {
    return basicEPSLastUpdate;
  }

  public String getDilutedEPSTTM() {
    return dilutedEPSTTM;
  }

  public String getDilutedEPSLastUpdate() {
    return dilutedEPSLastUpdate;
  }

  public String getBasicAvgSharesTTM() {
    return basicAvgSharesTTM;
  }

  public String getBasicAvgSharesLastUpdate() {
    return basicAvgSharesLastUpdate;
  }

  public String getDilutedAvgSharesTTM() {
    return dilutedAvgSharesTTM;
  }

  public String getDilutedAvgSharesLastUpdate() {
    return dilutedAvgSharesLastUpdate;
  }

  public String getNetIncomeContinuingDiscontinuedOpsTTM() {
    return netIncomeContinuingDiscontinuedOpsTTM;
  }

  public String getNetIncomeContinuingDiscontinuedOpsLastUpdate() {
    return netIncomeContinuingDiscontinuedOpsLastUpdate;
  }

  public String getNormalizedIncomeTTM() {
    return normalizedIncomeTTM;
  }

  public String getNormalizedIncomeLastUpdate() {
    return normalizedIncomeLastUpdate;
  }

  @Override
  public String toString() {
    return "CompanyIncomeStatement{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", totalRevenueTTM='" + totalRevenueTTM + '\'' +
            ", totalRevenueLastUpdate='" + totalRevenueLastUpdate + '\'' +
            ", pretaxIncomeTTM='" + pretaxIncomeTTM + '\'' +
            ", pretaxIncomeLastUpdate='" + pretaxIncomeLastUpdate + '\'' +
            ", taxProvisionTTM='" + taxProvisionTTM + '\'' +
            ", taxProvisionLastUpdate='" + taxProvisionLastUpdate + '\'' +
            ", netIncomeCommonStockholdersTTM='" + netIncomeCommonStockholdersTTM + '\'' +
            ", netIncomeCommonStockholdersLastUpdate='" + netIncomeCommonStockholdersLastUpdate + '\'' +
            ", basicEPSTTM='" + basicEPSTTM + '\'' +
            ", basicEPSLastUpdate='" + basicEPSLastUpdate + '\'' +
            ", dilutedEPSTTM='" + dilutedEPSTTM + '\'' +
            ", dilutedEPSLastUpdate='" + dilutedEPSLastUpdate + '\'' +
            ", basicAvgSharesTTM='" + basicAvgSharesTTM + '\'' +
            ", basicAvgSharesLastUpdate='" + basicAvgSharesLastUpdate + '\'' +
            ", dilutedAvgSharesTTM='" + dilutedAvgSharesTTM + '\'' +
            ", dilutedAvgSharesLastUpdate='" + dilutedAvgSharesLastUpdate + '\'' +
            ", netIncomeContinuingDiscontinuedOpsTTM='" + netIncomeContinuingDiscontinuedOpsTTM + '\'' +
            ", netIncomeContinuingDiscontinuedOpsLastUpdate='" + netIncomeContinuingDiscontinuedOpsLastUpdate + '\'' +
            ", normalizedIncomeTTM='" + normalizedIncomeTTM + '\'' +
            ", normalizedIncomeLastUpdate='" + normalizedIncomeLastUpdate + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyIncomeStatement that)) return false;
    return Objects.equals(getTotalRevenueTTM(), that.getTotalRevenueTTM())
            && Objects.equals(getTotalRevenueLastUpdate(), that.getTotalRevenueLastUpdate())
            && Objects.equals(getPretaxIncomeTTM(), that.getPretaxIncomeTTM())
            && Objects.equals(getPretaxIncomeLastUpdate(), that.getPretaxIncomeLastUpdate())
            && Objects.equals(getTaxProvisionTTM(), that.getTaxProvisionTTM())
            && Objects.equals(getTaxProvisionLastUpdate(), that.getTaxProvisionLastUpdate())
            && Objects.equals(getNetIncomeCommonStockholdersTTM(), that.getNetIncomeCommonStockholdersTTM())
            && Objects.equals(getNetIncomeCommonStockholdersLastUpdate(), that.getNetIncomeCommonStockholdersLastUpdate())
            && Objects.equals(getBasicEPSTTM(), that.getBasicEPSTTM()) && Objects.equals(getBasicEPSLastUpdate(), that.getBasicEPSLastUpdate())
            && Objects.equals(getDilutedEPSTTM(), that.getDilutedEPSTTM()) && Objects.equals(getDilutedEPSLastUpdate(), that.getDilutedEPSLastUpdate())
            && Objects.equals(getBasicAvgSharesTTM(), that.getBasicAvgSharesTTM()) && Objects.equals(getBasicAvgSharesLastUpdate(), that.getBasicAvgSharesLastUpdate())
            && Objects.equals(getDilutedAvgSharesTTM(), that.getDilutedAvgSharesTTM()) && Objects.equals(getDilutedAvgSharesLastUpdate(), that.getDilutedAvgSharesLastUpdate())
            && Objects.equals(getNetIncomeContinuingDiscontinuedOpsTTM(), that.getNetIncomeContinuingDiscontinuedOpsTTM())
            && Objects.equals(getNetIncomeContinuingDiscontinuedOpsLastUpdate(), that.getNetIncomeContinuingDiscontinuedOpsLastUpdate())
            && Objects.equals(getNormalizedIncomeTTM(), that.getNormalizedIncomeTTM())
            && Objects.equals(getNormalizedIncomeLastUpdate(), that.getNormalizedIncomeLastUpdate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTotalRevenueTTM(),
            getTotalRevenueLastUpdate(),
            getPretaxIncomeTTM(),
            getPretaxIncomeLastUpdate(),
            getTaxProvisionTTM(),
            getTaxProvisionLastUpdate(),
            getNetIncomeCommonStockholdersTTM(),
            getNetIncomeCommonStockholdersLastUpdate(),
            getBasicEPSTTM(),
            getBasicEPSLastUpdate(),
            getDilutedEPSTTM(),
            getDilutedEPSLastUpdate(),
            getBasicAvgSharesTTM(),
            getBasicAvgSharesLastUpdate(),
            getDilutedAvgSharesTTM(),
            getDilutedAvgSharesLastUpdate(),
            getNetIncomeContinuingDiscontinuedOpsTTM(),
            getNetIncomeContinuingDiscontinuedOpsLastUpdate(),
            getNormalizedIncomeTTM(),
            getNormalizedIncomeLastUpdate());
  }

  // Builder class
  public static class Builder extends AbstractCompanyInformation.Builder<CompanyIncomeStatement.Builder>{
    private String totalRevenueTTM = DEFAULT;
    private String totalRevenueLastUpdate = DEFAULT;
    private String pretaxIncomeTTM = DEFAULT;
    private String pretaxIncomeLastUpdate = DEFAULT;
    private String taxProvisionTTM = DEFAULT;
    private String taxProvisionLastUpdate = DEFAULT;
    private String netIncomeCommonStockholdersTTM = DEFAULT;
    private String netIncomeCommonStockholdersLastUpdate = DEFAULT;
    private String basicEPSTTM = DEFAULT;
    private String basicEPSLastUpdate = DEFAULT;
    private String dilutedEPSTTM = DEFAULT;
    private String dilutedEPSLastUpdate = DEFAULT;
    private String basicAvgSharesTTM = DEFAULT;
    private String basicAvgSharesLastUpdate = DEFAULT;
    private String dilutedAvgSharesTTM = DEFAULT;
    private String dilutedAvgSharesLastUpdate = DEFAULT;
    private String netIncomeContinuingDiscontinuedOpsTTM = DEFAULT;
    private String netIncomeContinuingDiscontinuedOpsLastUpdate = DEFAULT;
    private String normalizedIncomeTTM = DEFAULT;
    private String normalizedIncomeLastUpdate = DEFAULT;

    public Builder withTotalRevenueTTM(String totalRevenueTTM) {
      this.totalRevenueTTM = totalRevenueTTM;
      return this;
    }

    public Builder withTotalRevenueLastUpdate(String totalRevenueLastUpdate) {
      this.totalRevenueLastUpdate = totalRevenueLastUpdate;
      return this;
    }

    public Builder withPretaxIncomeTTM(String pretaxIncomeTTM) {
      this.pretaxIncomeTTM = pretaxIncomeTTM;
      return this;
    }

    public Builder withPretaxIncomeLastUpdate(String pretaxIncomeLastUpdate) {
      this.pretaxIncomeLastUpdate = pretaxIncomeLastUpdate;
      return this;
    }

    public Builder withTaxProvisionTTM(String taxProvisionTTM) {
      this.taxProvisionTTM = taxProvisionTTM;
      return this;
    }

    public Builder withTaxProvisionLastUpdate(String taxProvisionLastUpdate) {
      this.taxProvisionLastUpdate = taxProvisionLastUpdate;
      return this;
    }

    public Builder withNetIncomeCommonStockholdersTTM(String netIncomeCommonStockholdersTTM) {
      this.netIncomeCommonStockholdersTTM = netIncomeCommonStockholdersTTM;
      return this;
    }

    public Builder withNetIncomeCommonStockholdersLastUpdate(String netIncomeCommonStockholdersLastUpdate) {
      this.netIncomeCommonStockholdersLastUpdate = netIncomeCommonStockholdersLastUpdate;
      return this;
    }

    public Builder withBasicEPSTTM(String basicEPSTTM) {
      this.basicEPSTTM = basicEPSTTM;
      return this;
    }

    public Builder withBasicEPSLastUpdate(String basicEPSLastUpdate) {
      this.basicEPSLastUpdate = basicEPSLastUpdate;
      return this;
    }

    public Builder withDilutedEPSTTM(String dilutedEPSTTM) {
      this.dilutedEPSTTM = dilutedEPSTTM;
      return this;
    }

    public Builder withDilutedEPSLastUpdate(String dilutedEPSLastUpdate) {
      this.dilutedEPSLastUpdate = dilutedEPSLastUpdate;
      return this;
    }

    public Builder withBasicAvgSharesTTM(String basicAvgSharesTTM) {
      this.basicAvgSharesTTM = basicAvgSharesTTM;
      return this;
    }

    public Builder withBasicAvgSharesLastUpdate(String basicAvgSharesLastUpdate) {
      this.basicAvgSharesLastUpdate = basicAvgSharesLastUpdate;
      return this;
    }

    public Builder withDilutedAvgSharesTTM(String dilutedAvgSharesTTM) {
      this.dilutedAvgSharesTTM = dilutedAvgSharesTTM;
      return this;
    }

    public Builder withDilutedAvgSharesLastUpdate(String dilutedAvgSharesLastUpdate) {
      this.dilutedAvgSharesLastUpdate = dilutedAvgSharesLastUpdate;
      return this;
    }

    public Builder withNetIncomeContinuingDiscontinuedOpsTTM(String netIncomeContinuingDiscontinuedOpsTTM) {
      this.netIncomeContinuingDiscontinuedOpsTTM = netIncomeContinuingDiscontinuedOpsTTM;
      return this;
    }

    public Builder withNetIncomeContinuingDiscontinuedOpsLastUpdate(String netIncomeContinuingDiscontinuedOpsLastUpdate) {
      this.netIncomeContinuingDiscontinuedOpsLastUpdate = netIncomeContinuingDiscontinuedOpsLastUpdate;
      return this;
    }

    public Builder withNormalizedIncomeTTM(String normalizedIncomeTTM) {
      this.normalizedIncomeTTM = normalizedIncomeTTM;
      return this;
    }

    public Builder withNormalizedIncomeLastUpdate(String normalizedIncomeLastUpdate) {
      this.normalizedIncomeLastUpdate = normalizedIncomeLastUpdate;
      return this;
    }

    @Override
    public CompanyIncomeStatement build() {
      return new CompanyIncomeStatement(this);
    }

    @Override
    public CompanyIncomeStatement.Builder self() {
      return this;
    }
  }
}

