package org.opensource.model;

import java.util.Objects;

public class CompanyIncomeStatement extends AbstractCompanyInformation {

  // Total Revenue
  private final double totalRevenueTTM;
  private final double totalRevenueLastUpdate;

  // Pretax Income
  private final double pretaxIncomeTTM;
  private final double pretaxIncomeLastUpdate;

  // Tax Provision
  private final double taxProvisionTTM;
  private final double taxProvisionLastUpdate;

  // Net Income Common Stockholders
  private final double netIncomeCommonStockholdersTTM;
  private final double netIncomeCommonStockholdersLastUpdate;

  // Basic EPS (Earnings Per Share)
  private final double basicEPSTTM;
  private final double basicEPSLastUpdate;

  // Diluted EPS
  private final double dilutedEPSTTM;
  private final double dilutedEPSLastUpdate;

  // Basic Average Shares
  private final double basicAvgSharesTTM;
  private final double basicAvgSharesLastUpdate;

  // Diluted Average Shares
  private final double dilutedAvgSharesTTM;
  private final double dilutedAvgSharesLastUpdate;

  // Net Income from Continuing & Discontinued Operations
  private final double netIncomeContinuingDiscontinuedOpsTTM;
  private final double netIncomeContinuingDiscontinuedOpsLastUpdate;

  // Normalized Income
  private final double normalizedIncomeTTM;
  private final double normalizedIncomeLastUpdate;

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
  public double getTotalRevenueTTM() {
    return totalRevenueTTM;
  }

  public double getTotalRevenueLastUpdate() {
    return totalRevenueLastUpdate;
  }

  public double getPretaxIncomeTTM() {
    return pretaxIncomeTTM;
  }

  public double getPretaxIncomeLastUpdate() {
    return pretaxIncomeLastUpdate;
  }

  public double getTaxProvisionTTM() {
    return taxProvisionTTM;
  }

  public double getTaxProvisionLastUpdate() {
    return taxProvisionLastUpdate;
  }

  public double getNetIncomeCommonStockholdersTTM() {
    return netIncomeCommonStockholdersTTM;
  }

  public double getNetIncomeCommonStockholdersLastUpdate() {
    return netIncomeCommonStockholdersLastUpdate;
  }

  public double getBasicEPSTTM() {
    return basicEPSTTM;
  }

  public double getBasicEPSLastUpdate() {
    return basicEPSLastUpdate;
  }

  public double getDilutedEPSTTM() {
    return dilutedEPSTTM;
  }

  public double getDilutedEPSLastUpdate() {
    return dilutedEPSLastUpdate;
  }

  public double getBasicAvgSharesTTM() {
    return basicAvgSharesTTM;
  }

  public double getBasicAvgSharesLastUpdate() {
    return basicAvgSharesLastUpdate;
  }

  public double getDilutedAvgSharesTTM() {
    return dilutedAvgSharesTTM;
  }

  public double getDilutedAvgSharesLastUpdate() {
    return dilutedAvgSharesLastUpdate;
  }

  public double getNetIncomeContinuingDiscontinuedOpsTTM() {
    return netIncomeContinuingDiscontinuedOpsTTM;
  }

  public double getNetIncomeContinuingDiscontinuedOpsLastUpdate() {
    return netIncomeContinuingDiscontinuedOpsLastUpdate;
  }

  public double getNormalizedIncomeTTM() {
    return normalizedIncomeTTM;
  }

  public double getNormalizedIncomeLastUpdate() {
    return normalizedIncomeLastUpdate;
  }

  @Override
  public String toString() {
    return "CompanyIncomeStatement{" +
            "companyName='" + getCompanyName() + '\'' +
            ", companyTicker='" + getCompanyTicker() + '\'' +
            ", currentPrice='" + getCurrentPrice() + '\'' +
            ", totalRevenueTTM=" + totalRevenueTTM +
            ", totalRevenueLastUpdate=" + totalRevenueLastUpdate +
            ", pretaxIncomeTTM=" + pretaxIncomeTTM +
            ", pretaxIncomeLastUpdate=" + pretaxIncomeLastUpdate +
            ", taxProvisionTTM=" + taxProvisionTTM +
            ", taxProvisionLastUpdate=" + taxProvisionLastUpdate +
            ", netIncomeCommonStockholdersTTM=" + netIncomeCommonStockholdersTTM +
            ", netIncomeCommonStockholdersLastUpdate=" + netIncomeCommonStockholdersLastUpdate +
            ", basicEPSTTM=" + basicEPSTTM +
            ", basicEPSLastUpdate=" + basicEPSLastUpdate +
            ", dilutedEPSTTM=" + dilutedEPSTTM +
            ", dilutedEPSLastUpdate=" + dilutedEPSLastUpdate +
            ", basicAvgSharesTTM=" + basicAvgSharesTTM +
            ", basicAvgSharesLastUpdate=" + basicAvgSharesLastUpdate +
            ", dilutedAvgSharesTTM=" + dilutedAvgSharesTTM +
            ", dilutedAvgSharesLastUpdate=" + dilutedAvgSharesLastUpdate +
            ", netIncomeContinuingDiscontinuedOpsTTM=" + netIncomeContinuingDiscontinuedOpsTTM +
            ", netIncomeContinuingDiscontinuedOpsLastUpdate=" + netIncomeContinuingDiscontinuedOpsLastUpdate +
            ", normalizedIncomeTTM=" + normalizedIncomeTTM +
            ", normalizedIncomeLastUpdate=" + normalizedIncomeLastUpdate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CompanyIncomeStatement)) return false;
    CompanyIncomeStatement that = (CompanyIncomeStatement) o;
    return Double.compare(that.totalRevenueTTM, totalRevenueTTM) == 0 &&
            Double.compare(that.totalRevenueLastUpdate, totalRevenueLastUpdate) == 0 &&
            Double.compare(that.pretaxIncomeTTM, pretaxIncomeTTM) == 0 &&
            Double.compare(that.pretaxIncomeLastUpdate, pretaxIncomeLastUpdate) == 0 &&
            Double.compare(that.taxProvisionTTM, taxProvisionTTM) == 0 &&
            Double.compare(that.taxProvisionLastUpdate, taxProvisionLastUpdate) == 0 &&
            Double.compare(that.netIncomeCommonStockholdersTTM, netIncomeCommonStockholdersTTM) == 0 &&
            Double.compare(that.netIncomeCommonStockholdersLastUpdate, netIncomeCommonStockholdersLastUpdate) == 0 &&
            Double.compare(that.basicEPSTTM, basicEPSTTM) == 0 &&
            Double.compare(that.basicEPSLastUpdate, basicEPSLastUpdate) == 0 &&
            Double.compare(that.dilutedEPSTTM, dilutedEPSTTM) == 0 &&
            Double.compare(that.dilutedEPSLastUpdate, dilutedEPSLastUpdate) == 0 &&
            Double.compare(that.basicAvgSharesTTM, basicAvgSharesTTM) == 0 &&
            Double.compare(that.basicAvgSharesLastUpdate, basicAvgSharesLastUpdate) == 0 &&
            Double.compare(that.dilutedAvgSharesTTM, dilutedAvgSharesTTM) == 0 &&
            Double.compare(that.dilutedAvgSharesLastUpdate, dilutedAvgSharesLastUpdate) == 0 &&
            Double.compare(that.netIncomeContinuingDiscontinuedOpsTTM, netIncomeContinuingDiscontinuedOpsTTM) == 0 &&
            Double.compare(that.netIncomeContinuingDiscontinuedOpsLastUpdate, netIncomeContinuingDiscontinuedOpsLastUpdate) == 0 &&
            Double.compare(that.normalizedIncomeTTM, normalizedIncomeTTM) == 0 &&
            Double.compare(that.normalizedIncomeLastUpdate, normalizedIncomeLastUpdate) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalRevenueTTM, totalRevenueLastUpdate, pretaxIncomeTTM, pretaxIncomeLastUpdate, taxProvisionTTM, taxProvisionLastUpdate, netIncomeCommonStockholdersTTM, netIncomeCommonStockholdersLastUpdate, basicEPSTTM, basicEPSLastUpdate, dilutedEPSTTM, dilutedEPSLastUpdate, basicAvgSharesTTM, basicAvgSharesLastUpdate, dilutedAvgSharesTTM, dilutedAvgSharesLastUpdate, netIncomeContinuingDiscontinuedOpsTTM, netIncomeContinuingDiscontinuedOpsLastUpdate, normalizedIncomeTTM, normalizedIncomeLastUpdate);
  }

  // Builder class
  public static class Builder extends AbstractCompanyInformation.Builder<CompanyIncomeStatement.Builder> {

    private double totalRevenueTTM = DEFAULT_DOUBLE;
    private double totalRevenueLastUpdate = DEFAULT_DOUBLE;
    private double pretaxIncomeTTM = DEFAULT_DOUBLE;
    private double pretaxIncomeLastUpdate = DEFAULT_DOUBLE;
    private double taxProvisionTTM = DEFAULT_DOUBLE;
    private double taxProvisionLastUpdate = DEFAULT_DOUBLE;
    private double netIncomeCommonStockholdersTTM = DEFAULT_DOUBLE;
    private double netIncomeCommonStockholdersLastUpdate = DEFAULT_DOUBLE;
    private double basicEPSTTM = DEFAULT_DOUBLE;
    private double basicEPSLastUpdate = DEFAULT_DOUBLE;
    private double dilutedEPSTTM = DEFAULT_DOUBLE;
    private double dilutedEPSLastUpdate = DEFAULT_DOUBLE;
    private double basicAvgSharesTTM = DEFAULT_DOUBLE;
    private double basicAvgSharesLastUpdate = DEFAULT_DOUBLE;
    private double dilutedAvgSharesTTM = DEFAULT_DOUBLE;
    private double dilutedAvgSharesLastUpdate = DEFAULT_DOUBLE;
    private double netIncomeContinuingDiscontinuedOpsTTM = DEFAULT_DOUBLE;
    private double netIncomeContinuingDiscontinuedOpsLastUpdate = DEFAULT_DOUBLE;
    private double normalizedIncomeTTM = DEFAULT_DOUBLE;
    private double normalizedIncomeLastUpdate = DEFAULT_DOUBLE;

    public Builder withTotalRevenueTTM(double totalRevenueTTM) {
      this.totalRevenueTTM = totalRevenueTTM;
      return this;
    }

    public Builder withTotalRevenueLastUpdate(double totalRevenueLastUpdate) {
      this.totalRevenueLastUpdate = totalRevenueLastUpdate;
      return this;
    }

    public Builder withPretaxIncomeTTM(double pretaxIncomeTTM) {
      this.pretaxIncomeTTM = pretaxIncomeTTM;
      return this;
    }

    public Builder withPretaxIncomeLastUpdate(double pretaxIncomeLastUpdate) {
      this.pretaxIncomeLastUpdate = pretaxIncomeLastUpdate;
      return this;
    }

    public Builder withTaxProvisionTTM(double taxProvisionTTM) {
      this.taxProvisionTTM = taxProvisionTTM;
      return this;
    }

    public Builder withTaxProvisionLastUpdate(double taxProvisionLastUpdate) {
      this.taxProvisionLastUpdate = taxProvisionLastUpdate;
      return this;
    }

    public Builder withNetIncomeCommonStockholdersTTM(double netIncomeCommonStockholdersTTM) {
      this.netIncomeCommonStockholdersTTM = netIncomeCommonStockholdersTTM;
      return this;
    }

    public Builder withNetIncomeCommonStockholdersLastUpdate(double netIncomeCommonStockholdersLastUpdate) {
      this.netIncomeCommonStockholdersLastUpdate = netIncomeCommonStockholdersLastUpdate;
      return this;
    }

    public Builder withBasicEPSTTM(double basicEPSTTM) {
      this.basicEPSTTM = basicEPSTTM;
      return this;
    }

    public Builder withBasicEPSLastUpdate(double basicEPSLastUpdate) {
      this.basicEPSLastUpdate = basicEPSLastUpdate;
      return this;
    }

    public Builder withDilutedEPSTTM(double dilutedEPSTTM) {
      this.dilutedEPSTTM = dilutedEPSTTM;
      return this;
    }

    public Builder withDilutedEPSLastUpdate(double dilutedEPSLastUpdate) {
      this.dilutedEPSLastUpdate = dilutedEPSLastUpdate;
      return this;
    }

    public Builder withBasicAvgSharesTTM(double basicAvgSharesTTM) {
      this.basicAvgSharesTTM = basicAvgSharesTTM;
      return this;
    }

    public Builder withBasicAvgSharesLastUpdate(double basicAvgSharesLastUpdate) {
      this.basicAvgSharesLastUpdate = basicAvgSharesLastUpdate;
      return this;
    }

    public Builder withDilutedAvgSharesTTM(double dilutedAvgSharesTTM) {
      this.dilutedAvgSharesTTM = dilutedAvgSharesTTM;
      return this;
    }

    public Builder withDilutedAvgSharesLastUpdate(double dilutedAvgSharesLastUpdate) {
      this.dilutedAvgSharesLastUpdate = dilutedAvgSharesLastUpdate;
      return this;
    }

    public Builder withNetIncomeContinuingDiscontinuedOpsTTM(double netIncomeContinuingDiscontinuedOpsTTM) {
      this.netIncomeContinuingDiscontinuedOpsTTM = netIncomeContinuingDiscontinuedOpsTTM;
      return this;
    }

    public Builder withNetIncomeContinuingDiscontinuedOpsLastUpdate(double netIncomeContinuingDiscontinuedOpsLastUpdate) {
      this.netIncomeContinuingDiscontinuedOpsLastUpdate = netIncomeContinuingDiscontinuedOpsLastUpdate;
      return this;
    }

    public Builder withNormalizedIncomeTTM(double normalizedIncomeTTM) {
      this.normalizedIncomeTTM = normalizedIncomeTTM;
      return this;
    }

    public Builder withNormalizedIncomeLastUpdate(double normalizedIncomeLastUpdate) {
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
