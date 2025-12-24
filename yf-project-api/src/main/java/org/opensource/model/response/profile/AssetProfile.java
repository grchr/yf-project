package org.opensource.model.response.profile;

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
	private Long compensationRisk;

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
	private Long shareHolderRightsRisk;

	@JsonProperty("executiveTeam")
	private List<String> executiveTeam;

	@JsonProperty("compensationAsOfEpochDate")
	private Long compensationAsOfEpochDate;

	@JsonProperty("fullTimeEmployees")
	private Long fullTimeEmployees;

	@JsonProperty("longBusinessSummary")
	private String longBusinessSummary;

	@JsonProperty("boardRisk")
	private Long boardRisk;

	@JsonProperty("governanceEpochDate")
	private Long governanceEpochDate;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("overallRisk")
	private Long overallRisk;

	@JsonProperty("auditRisk")
	private Long auditRisk;

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

	public Long getCompensationRisk(){
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

	public Long getShareHolderRightsRisk(){
		return shareHolderRightsRisk;
	}

	public List<String> getExecutiveTeam(){
		return executiveTeam;
	}

	public Long getCompensationAsOfEpochDate(){
		return compensationAsOfEpochDate;
	}

	public Long getFullTimeEmployees(){
		return fullTimeEmployees;
	}

	public String getLongBusinessSummary(){
		return longBusinessSummary;
	}

	public Long getBoardRisk(){
		return boardRisk;
	}

	public Long getGovernanceEpochDate(){
		return governanceEpochDate;
	}

	public String getPhone(){
		return phone;
	}

	public Long getMaxAge(){
		return maxAge;
	}

	public Long getOverallRisk(){
		return overallRisk;
	}

	public Long getAuditRisk(){
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

	@Override
 	public String toString(){
		return
			"AssetProfile{" +
			"zip = '" + zip + '\'' +
			",country = '" + country + '\'' +
			",website = '" + website + '\'' +
			",compensationRisk = '" + compensationRisk + '\'' +
			",industryDisp = '" + industryDisp + '\'' +
			",city = '" + city + '\'' +
			",address1 = '" + address1 + '\'' +
			",companyOfficers = '" + companyOfficers + '\'' +
			",industry = '" + industry + '\'' +
			",shareHolderRightsRisk = '" + shareHolderRightsRisk + '\'' +
			",executiveTeam = '" + executiveTeam + '\'' +
			",compensationAsOfEpochDate = '" + compensationAsOfEpochDate + '\'' +
			",fullTimeEmployees = '" + fullTimeEmployees + '\'' +
			",longBusinessSummary = '" + longBusinessSummary + '\'' +
			",boardRisk = '" + boardRisk + '\'' +
			",governanceEpochDate = '" + governanceEpochDate + '\'' +
			",phone = '" + phone + '\'' +
			",maxAge = '" + maxAge + '\'' +
			",overallRisk = '" + overallRisk + '\'' +
			",auditRisk = '" + auditRisk + '\'' +
			",sectorKey = '" + sectorKey + '\'' +
			",sector = '" + sector + '\'' +
			",sectorDisp = '" + sectorDisp + '\'' +
			",industryKey = '" + industryKey + '\'' +
			"}";
		}
}