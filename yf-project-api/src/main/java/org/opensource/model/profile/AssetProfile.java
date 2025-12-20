package org.opensource.model.profile;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetProfile{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("website")
	private String website;

	@JsonProperty("compensationRisk")
	private int compensationRisk;

	@JsonProperty("industryDisp")
	private String industryDisp;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("companyOfficers")
	private List<CompanyOfficersItem> companyOfficers;

	@JsonProperty("industry")
	private String industry;

	@JsonProperty("shareHolderRightsRisk")
	private int shareHolderRightsRisk;

	@JsonProperty("executiveTeam")
	private List<String> executiveTeam;

	@JsonProperty("compensationAsOfEpochDate")
	private int compensationAsOfEpochDate;

	@JsonProperty("fullTimeEmployees")
	private int fullTimeEmployees;

	@JsonProperty("longBusinessSummary")
	private String longBusinessSummary;

	@JsonProperty("boardRisk")
	private int boardRisk;

	@JsonProperty("governanceEpochDate")
	private int governanceEpochDate;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("overallRisk")
	private int overallRisk;

	@JsonProperty("auditRisk")
	private int auditRisk;

	@JsonProperty("sectorKey")
	private String sectorKey;

	@JsonProperty("sector")
	private String sector;

	@JsonProperty("sectorDisp")
	private String sectorDisp;

	@JsonProperty("industryKey")
	private String industryKey;

	public String getZip(){
		return zip;
	}

	public String getCountry(){
		return country;
	}

	public String getWebsite(){
		return website;
	}

	public int getCompensationRisk(){
		return compensationRisk;
	}

	public String getIndustryDisp(){
		return industryDisp;
	}

	public String getCity(){
		return city;
	}

	public String getAddress1(){
		return address1;
	}

	public List<CompanyOfficersItem> getCompanyOfficers(){
		return companyOfficers;
	}

	public String getIndustry(){
		return industry;
	}

	public int getShareHolderRightsRisk(){
		return shareHolderRightsRisk;
	}

	public List<String> getExecutiveTeam(){
		return executiveTeam;
	}

	public int getCompensationAsOfEpochDate(){
		return compensationAsOfEpochDate;
	}

	public int getFullTimeEmployees(){
		return fullTimeEmployees;
	}

	public String getLongBusinessSummary(){
		return longBusinessSummary;
	}

	public int getBoardRisk(){
		return boardRisk;
	}

	public int getGovernanceEpochDate(){
		return governanceEpochDate;
	}

	public String getPhone(){
		return phone;
	}

	public int getMaxAge(){
		return maxAge;
	}

	public int getOverallRisk(){
		return overallRisk;
	}

	public int getAuditRisk(){
		return auditRisk;
	}

	public String getSectorKey(){
		return sectorKey;
	}

	public String getSector(){
		return sector;
	}

	public String getSectorDisp(){
		return sectorDisp;
	}

	public String getIndustryKey(){
		return industryKey;
	}
}