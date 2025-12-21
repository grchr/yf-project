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
	private Integer compensationRisk;

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
	private Integer shareHolderRightsRisk;

	@JsonProperty("executiveTeam")
	private List<String> executiveTeam;

	@JsonProperty("compensationAsOfEpochDate")
	private Integer compensationAsOfEpochDate;

	@JsonProperty("fullTimeEmployees")
	private Integer fullTimeEmployees;

	@JsonProperty("longBusinessSummary")
	private String longBusinessSummary;

	@JsonProperty("boardRisk")
	private Integer boardRisk;

	@JsonProperty("governanceEpochDate")
	private Integer governanceEpochDate;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("overallRisk")
	private Integer overallRisk;

	@JsonProperty("auditRisk")
	private Integer auditRisk;

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

	public Integer getCompensationRisk(){
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

	public Integer getShareHolderRightsRisk(){
		return shareHolderRightsRisk;
	}

	public List<String> getExecutiveTeam(){
		return executiveTeam;
	}

	public Integer getCompensationAsOfEpochDate(){
		return compensationAsOfEpochDate;
	}

	public Integer getFullTimeEmployees(){
		return fullTimeEmployees;
	}

	public String getLongBusinessSummary(){
		return longBusinessSummary;
	}

	public Integer getBoardRisk(){
		return boardRisk;
	}

	public Integer getGovernanceEpochDate(){
		return governanceEpochDate;
	}

	public String getPhone(){
		return phone;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public Integer getOverallRisk(){
		return overallRisk;
	}

	public Integer getAuditRisk(){
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