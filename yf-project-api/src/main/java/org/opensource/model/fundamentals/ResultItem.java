package org.opensource.model.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("annualNetIncome")
	private List<AnnualNetIncomeItem> annualNetIncome;

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("timestamp")
	private List<Integer> timestamp;

	@JsonProperty("annualTotalRevenue")
	private List<AnnualTotalRevenueItem> annualTotalRevenue;

	@JsonProperty("annualOperatingIncome")
	private List<AnnualOperatingIncomeItem> annualOperatingIncome;

	public List<AnnualNetIncomeItem> getAnnualNetIncome(){
		return annualNetIncome;
	}

	public Meta getMeta(){
		return meta;
	}

	public List<Integer> getTimestamp(){
		return timestamp;
	}

	public List<AnnualTotalRevenueItem> getAnnualTotalRevenue(){
		return annualTotalRevenue;
	}

	public List<AnnualOperatingIncomeItem> getAnnualOperatingIncome(){
		return annualOperatingIncome;
	}

	@Override
 	public String toString(){
		return
			"ResultItem{" +
			"annualNetIncome = '" + annualNetIncome + '\'' +
			",meta = '" + meta + '\'' +
			",timestamp = '" + timestamp + '\'' +
			",annualTotalRevenue = '" + annualTotalRevenue + '\'' +
			",annualOperatingIncome = '" + annualOperatingIncome + '\'' +
			"}";
		}
}